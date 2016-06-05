<?php
	
	include_once(ROOT_DIR."model/user_complaint.php");

	class UserComplaintController{

		public $model;
		public $final_result;

		public function __construct(){

			$this->model = new UserComplaint();

		}

		public function getComplaint(){

			$result = $this->model->getUserComplanint($_POST[user_id], $_POST[contact]);						

			if($result === true)
				$final_result = array(success => 1 );
			else 
				$final_result = array(success => 0 );

			return $final_result;
		}

	}

?>