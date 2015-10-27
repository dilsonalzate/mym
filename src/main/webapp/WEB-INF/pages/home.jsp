<!DOCTYPE html>
<html ng-app="employeeStore">

  <head>
   <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/mym.css">
    <link rel="stylesheet" href="./css/simple-sidebar.css">
  </head>

  <body ng-controller='TestCtrl'>
  <div id="wrapper">
    <div class="tabbable tabs-left">
    	<div id="sidebar-wrapper">
            <ul class="sidebar-nav">
            <li class="sidebar-brand" style="color:white">
                        MYM
            </li>
         <li ng-class="getTabClass(1)" ng-click="setActiveTab(1)"><a href="#deal" data-toggle="tab">Empleados</a></li>
         <li ng-class="getTabClass(2)" ng-click="setActiveTab(2)"><a href="#bond" data-toggle="tab">Roles</a></li>
         <li ng-class="getTabClass(3)" ng-click="setActiveTab(3)"><a href="#collateral" data-toggle="tab">Actividades</a></li>
         <li ng-class="getTabClass(4)" ng-click="setActiveTab(4)"><a href="#rating" data-toggle="tab">Programaciones</a></li>
      </ul>
        </div>	
      <div class="tab-content">
        <div ng-class="getTabPaneClass(1)" id="deal">    
           
    	   <div class="container" ng-controller="EmployeeController as employee">
	    	   <div class="modal fade" id="userModel" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
                            <h4 class="modal-title" id="myModalLabel" ng-hide="editMode">Add User</h4>
                            <h4 class="modal-title" id="myModalLabel" ng-show="editMode">Edit User</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" role="form" name="addempleadoform" novalidate ng-submit="addEmployee()" novalidate>
                                <div class="form-group">
						          <label class="control-label col-sm-3" for="user-name">User Name:</label>
						          <div class="col-sm-9">          
						            <input type="text" class="form-control" id="user-name" ng-model="employee.username" required>
						          </div>
						        </div>
						        <div class="form-group">
						          <label class="control-label col-sm-3" for="name">Nombre: </label>
						          <div class="col-sm-4">
						            <input type="text" class="form-control" id="name" ng-model="employee.nombre" required>
						          </div>
						        </div>
						        <div class="form-group">
						          <label class="control-label col-sm-3" for="apellido">Apellido:</label>
						          <div class="col-sm-4">          
						            <input type="text" class="form-control" id="apellido" ng-model="employee.apellido" required>
						          </div>
						        </div>
						        <div class="form-group">
						          <label class="control-label col-sm-3" for="nit">Cedula:</label>
						          <div class="col-sm-4">          
						            <input type="text" class="form-control" id="nit" ng-model="employee.cedula" required>
						          </div>
						        </div>
						        
						        <div class="form-group">
						          <label class="control-label col-sm-3" for="telefono">Telefono:</label>
						          <div class="col-sm-4">          
						            <input type="text" class="form-control" id="telefono" ng-model="employee.telefono" required>
						          </div>
						        </div>
						        
						        <div class="form-group">
						          <label class="control-label col-sm-3" for="celular">Celular:</label>
						          <div class="col-sm-4">          
						            <input type="text" class="form-control" id="celular" ng-model="employee.celular">
						          </div>
						        </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-10">
                                        <span data-ng-hide="editMode">
                                            <input type="submit" value="Add" ng-disabled="addempleadoform.$invalid" class="btn btn-primary" />
                                        </span>
                                        <span data-ng-show="editMode">
                                            <input type="button" value="Update" ng-disabled="addempleadoform.$invalid" data-ng-click="update()" class="btn btn-primary" />
                                        </span>
                                        <input type="button" value="Cancel" data-ng-click="cancel()" class="btn btn-primary" />
                                    </div>
                                </div>
                                
          <table class="table table-striped">
			  <thead>	
			    <tr>
			      <th>Edit</th>
			      <th>First Name</th>
			      <th>Last Name</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr ng-repeat="empleado in empleados">
			      <td>
			        <button class="btn" data-ng-click="editarModal(empleado)">
			          <span class="glyphicon glyphicon-pencil"></span>
			        </button>
			        <button class="btn" data-ng-click="showDeleteModal(empleado)">
			          <span class="glyphicon glyphicon-trash"></span>
			        </button>
			      </td>
			      <td>{{ empleado.nombre }}</td>
			      <td>{{ empleado.apellido }}</td>
			    </tr>
			  </tbody>
			</table>
		<button type="button" data-ng-click="mostrarModal()" class="btn btn-primary">Agregar Empleado</button>
		
                            </form>
                        </div>
                    </div>
                </div>
            </div>
		    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-hidden="true">
			 <div class="modal-dialog">
				 <div class="modal-content">
					 <div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
					 <h4 class="modal-title" id="myModalLabel">Confirm Action</h4>
					 </div>
					 <div class="modal-body">
					 	Are you sure to delete?
					 </div>
					 <div class="modal-footer">
					 <button type="button" class="btn btn-default" data-ng-click="deleteEmployee()">Ok</button>
					 <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					 </div>
				 </div>
			 </div>
		    </div>
	        <table class="table table-striped">
			  <thead>	
			    <tr>
			      <th>Edit</th>
			      <th>First Name</th>
			      <th>Last Name</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr ng-repeat="empleado in empleados">
			      <td>
			        <button class="btn" data-ng-click="editarModal(empleado)">
			          <span class="glyphicon glyphicon-pencil"></span>
			        </button>
			        <button class="btn" data-ng-click="showDeleteModal(empleado)">
			          <span class="glyphicon glyphicon-trash"></span>
			        </button>
			      </td>
			      <td>{{ empleado.nombre }}</td>
			      <td>{{ empleado.apellido }}</td>
			    </tr>
			  </tbody>
			</table>
		<button type="submit" data-ng-click="mostrarModal()" class="btn btn-primary">Agregar Empleado</button>
      </div>
    </div>       
        
	    <div ng-class="getTabPaneClass(2)" id="bond">     
	   		 <div ng-include="'./js/add-team-form.html'"></div>
	    </div>
        
        <div ng-class="getTabPaneClass(3)" id="collateral">     
          <div ng-include="'./js/manage-activity-form.html'"></div>
        </div>
        
        <div ng-class="getTabPaneClass(4)" id="rating">     
          <a href="${pageContext.request.contextPath}/team/add.html">Add new team</a><br/>
		   <a href="${pageContext.request.contextPath}/team/list.html">Team list</a><br/>
        </div>      
      
      </div>
    </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="./js/principal.js" type="text/javascript"></script>
    <script src="./js/employee.js" type="text/javascript"></script>
  </body>

</html>
