<?php
	include_once("config.php");
	include_once("constants.php");
	include(ROOT_DIR.'controller/register_compalint_controller.php');

	$controller = new RegisterComplaintController();
	$result = $controller->register();

	echo json_encode($result);
?>