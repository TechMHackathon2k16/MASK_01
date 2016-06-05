<?php
	
	include_once("config.php");
	include_once("constants.php");
	include(ROOT_DIR.'controller/user_compalint_controller.php');

	$controller = new UserComplaintController();
	$result = $controller->getComplaints();

	echo json_encode($result);

?>