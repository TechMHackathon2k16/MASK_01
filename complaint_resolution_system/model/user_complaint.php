<?php
	
	include_once(ROOT_DIR.'model/connection.php');

	class UserComplaint{

		public $conn;
		
		public function __construct(){

			$this->conn = new Connection();
			
		}
													//0->pending 1->completed
		public function getUserComplanint($user_id, $status){

			if($status == 0)
				return $this->getPendingComplaints($user_id);

			else
				return $this->getCompletedComplaints($user_id);				

			

		}

		public function getPendingComplaints($user_id){

			//$nconn1 = $this->conn->getConnectionOne(); 
	 		$nconn2 = $this->conn->getConnectionTwo();

	 		$sql = "SELECT complaint_id,complaint_details,complaint_date ORDER BY complaint_id DESC from complaint_table where user_id=$user_id and complaint_status IN(001,101,201,301)";
			
			//echo $sql;

			$result = $nconn2->query($sql);

			if($result->num_rows > 0){

				$complaints = array();
				$index = 0;
	 			while($row = $result->fetch_asscoc()){
	 				$complaints[$index++] = array(comaplint_id=>$row['complaint_id'], complaint_details=>row['complaint_details'], date=>$row['complaint_date']);
	 			}

	 			$this->conn->closeConnection();
				$nconn2 = null;
	 			return $complaints;
	 		}
	 		else{
	 			$this->conn->closeConnection();
				$nconn2 = null;
				return null;
	 		}
		}

		public function getCompletedComplaints($user_id){
		
			//$nconn1 = $this->conn->getConnectionOne(); 
	 		$nconn2 = $this->conn->getConnectionTwo();

	 		$sql = "SELECT complaint_id,complaint_details,complaint_date,complaint_res_date ORDER BY complaint_id DESC from complaint_table where user_id=$user_id and complaint_status=401";
			
			//echo $sql;

			$result = $nconn2->query($sql);

			if($result->num_rows > 0){

				$complaints = array();
				$index = 0;
	 			while($row = $result->fetch_asscoc()){
	 				$complaints[$index++] = array(comaplint_id=>$row['complaint_id'], complaint_details=>row['complaint_details'], date=>$row['complaint_date'], complaint_resolve_date=>$row['complaint_res_date']);
	 			}

	 			$this->conn->closeConnection();
				$nconn2 = null;
	 			return $complaints;
	 		}
	 		else{
	 			$this->conn->closeConnection();
				$nconn2 = null;
				return null;
	 		}

		}

	}

?>