<?php
	include_once($_SERVER['DOCUMENT_ROOT'].'ComplaintResolutionSystem/complaint_resolution_system/config.php');
	include_once(ROOT_DIR.'model/validate.php');
	include_once(ROOT_DIR.'constants.php');

	class LoginController{

		public $final_result; 

		public function invoke(){
									
			$validateModel = new Validate();
											//user id 			//user type 0->user , 1->Employee
			$result = $validateModel->check($_POST['user_id'], $_POST["user_type"]);
			//var_dump($result);

			if($result != null){ //if valid user, result contains user details

				$this->final_result = array(success => 1, user => $result);

			}
			else{

				$this->final_result = array(success => 0); //if failed to find the user

			}

			return $this->final_result;
		}

	}

?>
