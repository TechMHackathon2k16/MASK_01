<?php
	
	class Connection{		
		
		private $conn1;
		private $conn2;
		private $servername = 'localhost';
		private $username = 'root';
		private $password = '';
		private $databaseName1= 'predefined_db';
		private $databaseName2= 'smart_city';

		public function __construct(){
			//create connection
			$this->conn1 = new mysqli($this->servername, $this->username, $this->password, $this->databaseName1);
			//check connection
			if($this->conn1->connect_error)
			{
				die("connection failed database 1: ". $this->$conn1->connect_error);
				$this->conn1 = null;
			}

			$this->conn2 = new mysqli($this->servername, $this->username, $this->password, $this->databaseName2);
			//check connection
			if($this->conn2->connect_error)
			{
				die("connection failed database 2: ". $this->$conn2->connect_error);
				$this->conn2 = null;
			}
			
		}
		public function getConnectionOne(){
			
			return $this->conn1;
		}

		public function getConnectionTwo(){
			
			return $this->conn2;
		}
		
		public function closeConnection(){
			$this->conn1->close();
			$this->conn2->close();
		}
		
	}
?>