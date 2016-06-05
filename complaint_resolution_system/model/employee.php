<?php

	class Employee{

		public $emp_id;
		public $dept_id;
		public $emp_name;
		public $emp_contact;		

		public function __construct($emp_id, $dept_id, $emp_name, $emp_contact){

			$this->emp_id = $emp_id;
			$this->dept_id = $dept_id;
			$this->emp_name = $emp_name;
			$this->$emp_contact = $$emp_contact;

		}
	}

?>