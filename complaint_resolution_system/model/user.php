<?php

	class User{

		public $user_id;
		public $user_name;
		public $user_contact;
		public $user_add;		

		public function __construct($user_id, $user_name, $user_contact, $user_add){

			$this->user_id = $user_id;
			$this->user_name = $user_name;
			$this->user_contact = $user_contact;
			$this->user_add = $user_add;

		}
	}

?>