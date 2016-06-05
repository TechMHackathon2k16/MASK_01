<?php
	
	include_once(ROOT_DIR.'model/connection.php');

	class UpdateContact{

		public $conn;
		
		public function __construct(){

			$this->conn = new Connection();
			
		}

		public function updateContact($user_id, $user_contact){

			//$nconn1 = $this->conn->getConnectionOne(); 
	 		$nconn2 = $this->conn->getConnectionTwo();

	 		$sql = "UPDATE user set user_contact=$user_contact where user_id=$user_id";
			
			echo $sql;

			$result = $nconn2->query($sql);
			var_dump($result);
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