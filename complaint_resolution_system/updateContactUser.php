<?php
	include_once('config.php');
	include_once('constants.php');
	include(ROOT_DIR.'controller/update_contact_controller.php');

	$controller = new UpdateContactController();
	$result = $controller->update();

	echo json_encode($result);

?>