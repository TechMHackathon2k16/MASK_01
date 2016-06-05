<?php
	include_once(ROOT_DIR."model/connection.php");
	include_once(ROOT_DIR."model/user.php");
	include_once(ROOT_DIR."model/employee.php");

	 class Validate{
	 	public $conn;
	 	
	 	public function __construct(){

	 		$this->conn = new Connection();
	 		
	 	}

	 	public function check($user_id, $user_type){

	 		// echo "$user_id $user_type\n";
	 		if($user_type == 0){ //normal user

	 			return $this->user_validate($user_id);

	 		}
	 		else{

	 			return $this->employee_validate($user_id);

	 		}

	 	}

	 	public function user_validate($user_id){
	 		$user_data = null;
	 		$nconn1 = $this->conn->getConnectionOne(); 
	 		$nconn2 = $this->conn->getConnectionTwo();

	 		// var_dump($nconn1);
	 		// var_dump($nconn2);
	 		$sql = "SELECT * from user WHERE user_id =".$user_id."";

	 		// echo "$sql";
	 		
	 		$result = $nconn2->query($sql); //get user data from user table

	 		// var_dump($result);

	 		if($result->num_rows > 0){

	 			while($row = $result->fetch_asscoc()){
	 				$user_data = new User($row['user_id'], $row['user_name'], $row['user_contact'], $row['user_add']);
	 			}
	 		}
	 		else{

	 			$sql = "SELECT * from aadhar_test where aadhar_no = ".$user_id."";

	 			$result = $nconn1->query($sql); //get user data from aadhar table
	 			// var_dump($result);

	 			if($result->num_rows > 0){
	 				// echo"here";
	 				while($row = $result->fetch_asscoc()){
	 					$user_data = new User($row['user_id'], $row['user_name'], $row['user_contact'], $row['user_add']);

	 					$sql = "INSERT INTO user VALUES ('$user_data->user_id', '$user_data->user_name', '$user_data->user_contact','$user_data->user_add')";
	 					//add the user to user table
	 					if($nconn2->query($sql) != true)
	 						$user_data = null;
	 				}
	 			}
	 			// echo "here2";
	 		}

	 		$this->conn->closeConnection();
	 		$nconn1 = null;
	 		$nconn2 = null;

	 		// var_dump($user_data);

	 		if($user_data != null){
	 			// echo "here 3";
	 			return (array)$user_data;
	 		}

	 		return null;

	 	}

	 	public function employee_validate($emp_id){
	 		$emp_data = null;

	 		$nconn1 = $this->conn->getConnectionOne(); 
	 		$nconn2 = $this->conn->getConnectionTwo();

	 		$sql = "SELECT * from employee_table WHERE emp_id =".$emp_id."";
	 		$result = $nconn2->query($sql); //get employee data from employee table

	 		if($result->num_rows > 0){

	 			while($row = $result->fetch_asscoc()){
	 				$emp_data = new Emplpoyee($row['emp_id'], $row['dept_id'], $row['emp_name'], $row['emp_contact']);
	 			}
	 		}
	 		else{

	 			$sql = "SELECT * from emp_test where emp_id = ".$emp_id."";

	 			$result = $nconn1->query($sql); //get employee data from emp_test table

	 			if($result->num_rows > 0){

	 				while($row = $result->fetch_asscoc()){
	 					$emp_data = new Emplpoyee($row['emp_id'], $row['dept_id'], $row['emp_name'], $row['emp_contact']);

	 					$sql = "INSERT INTO employee_table VALUES ('$emp_data->emp_id', '$emp_data->dept_id', '$emp_data->emp_name','$emp_data->emp_contact')";
	 					//add the user to user table
	 					if($nconn2->query($sql) != true)
	 						$emp_data = null;
	 				}
	 			}
	 		}

	 		$this->conn->closeConnection();
	 		$nconn1 = null;
	 		$nconn2 = null;

	 		if($emp_data != null){
	 			return (array)$emp_data;
	 		}

	 		return null;
	 	}

	 }

?>