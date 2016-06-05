<?php
	
	include_once(ROOT_DIR.'model/connection.php');

	class RegisterComplaint{

		public $conn;
		
		public function __construct(){

			$this->conn = new Connection();
			
		}

		public function registerComplaint($user_id, $complaint_details, $dept_id, $complaint_add){

			//$nconn1 = $this->conn->getConnectionOne(); 
	 		$nconn2 = $this->conn->getConnectionTwo();

	 		$sql = "SELECT CURDATE()";
	 		$date = $nconn2->query($sql); //get current date
	 		$date = $date->fetch_assoc();
	 		$date = $date['CURDATE()'];
	 		
	 		// var_dump($date);
	 		// echo $date;

	 		$sql = "INSERT into complaint_table(user_id,complaint_details,dept_id,complaint_date, complaint_add)
values
($user_id, $complaint_details, $dept_id, $date, $complaint_add)";
			
			//echo $sql;
			$result = $nconn2->query($sql);
			//var_dump($result);
			if($result === true){
				$this->conn->closeConnection();
				$nconn2 = null;
				return true;
			}
			else{
				$this->conn->closeConnection();
				$nconn2 = null;
				return false;	
			}

		}

	}

?>