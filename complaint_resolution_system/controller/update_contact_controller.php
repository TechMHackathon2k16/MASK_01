<?php
	
	include_once(ROOT_DIR."model/update_contact.php");

	class UpdateContactController{

		public $model;
		public $final_result;

		public function __construct(){

			$this->model = new UpdateContact();

		}

		public function update(){

			$result = $this->model->updateContact($_POST[user_id], $_POST[contact]);						

			if($result === true)
				$final_result = array(success => 1 );
			else 
				$final_result = array(success => 0 );

			return $final_result;
		}

	}

?>