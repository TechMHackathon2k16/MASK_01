<?php
	
	include_once(ROOT_DIR."model/register_complaint.php");

	class RegisterComplaintController{

		public $model;
		public $final_result;

		public function __construct(){

			$this->model = new RegisterComplaint();

		}

		public function register(){

			$result = $this->model->registerComplaint($_POST[user_id], $_POST[complaint_details], $_POST[department], $_POST[address]);						

			if($result === true)
				$final_result = array(success => 1 );
			else 
				$final_result = array(success => 0 );

			return $final_result;
		}

	}

?>