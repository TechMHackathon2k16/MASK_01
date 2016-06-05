<?php
	
	include_once(ROOT_DIR."model/user_complaint.php");

	class UserComplaintController{

		public $model;
		public $final_result;

		public function __construct(){

			$this->model = new UserComplaint();

		}

		public function getComplaint(){
																		//0->pending, //1->completed
			$result = $this->model->getUserComplanint($_POST[user_id], $_POST[status]);						

			if($result != null)
				$final_result = array(success => 1 , complaints => $result); //return complaints based on 
			else 
				$final_result = array(success => 0 );

			return $final_result;
		}

	}

?>