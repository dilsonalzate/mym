(function(){

var app = angular.module('employeeStore', []);

app.controller('EmployeeController', ['$scope', '$http', function($scope, $http){
	
	$scope.employee = null;
	$scope.addEmployee = function() {
		$http({method: 'POST', url: '/mymlogistica/employee/add', data:$scope.employee}).
        success(function(data, status, headers, config) {
        	$scope.employee = {};
        	$('#userModel').modal('hide');
        	getEmpleados();
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
		
      };
      
      $scope.update = function() {
  		$http({method: 'PUT', url: '/mymlogistica/employee/update', data:$scope.employee}).
          success(function(data, status, headers, config) {
          	$scope.employee = {};
          	$('#userModel').modal('hide');
          	getEmpleados();
          }).
          error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            status;
          });
  		
        };
    
    $scope.mostrarModal = function() {
        $scope.employee = {};
        $scope.editMode = false;
        $scope.addempleadoform.$setPristine(true);
        $('#userModel').modal('show');
    };

    $scope.editarModal = function() {
        $scope.employee = this.empleado;
        $scope.editMode = true;
        $scope.addempleadoform.$setPristine(true);
        $('#userModel').modal('show');
    };
    
    $scope.showDeleteModal = function(data) {
    	$scope.employee = data;
        $('#confirmModal').modal('show');
    };
    
    $scope.deleteEmployee = function() {
    	
//        $scope.employee = this.empleado;
        $http({method: 'POST', url: '/mymlogistica/employee/delete', data:$scope.employee}).
        success(function(data, status, headers, config) {
        	$scope.employee = {};
        	$('#confirmModal').modal('hide');
        	getEmpleados();
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
    };
   
    $scope.cancel = function () {
        $scope.employee = {};
        $('#userModel').modal('hide');
        getEmpleados();
    };
    
    function getEmpleados(){
    	$http({method: 'GET', url: '/mymlogistica/employee/getEmpleados'}).
        success(function(data, status, headers, config) {
        	$scope.empleados = data;
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
    }
    
    getEmpleados();
}]);

app.controller('TestCtrl', function($scope){
  var tabClasses = [];
  
  function initTabs() {
    tabClasses = ["","","",""];
  }
  
  $scope.getTabClass = function (tabNum) {
    return tabClasses[tabNum];
  };
  
  $scope.getTabPaneClass = function (tabNum) {
    return "tab-pane " + tabClasses[tabNum];
  };
  
  $scope.setActiveTab = function (tabNum) {
    initTabs();
    tabClasses[tabNum] = "active";
  };
  
  $scope.tab1 = "This is first section";
  $scope.tab2 = "This is SECOND section";
  $scope.tab3 = "This is THIRD section";
  $scope.tab4 = "This is FOUTRH section";
  
  //Initialize 
  initTabs();
  $scope.setActiveTab(1);
});


app.controller("RoleController", ['$scope', '$http', function($scope, $http) {
	$scope.role = null;
	$scope.addRole = function() {
		$http({method: 'POST', url: '/mymlogistica/role/add', data:$scope.roleCtrl.role}).
        success(function(data, status, headers, config) {
        	$scope.roleCtrl.role = {};
        	$('#roleModel').modal('hide');
        	getRoles();
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
		
      };
      
      $scope.updateRole = function() {
  		$http({method: 'PUT', url: '/mymlogistica/role/update', data:$scope.roleCtrl.role}).
          success(function(data, status, headers, config) {
          	$scope.roleCtrl.role = {};
          	$('#roleModel').modal('hide');
          	getRoles();
          }).
          error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            status;
          });
  		
        };
    
    $scope.mostrarRoleModal = function() {
        $scope.role = {};
        $scope.editMode = false;
        $scope.addroleform.$setPristine(true);
        $('#roleModel').modal('show');
    };

    $scope.editarModal = function() {
        $scope.roleCtrl.role = this.role;
        $scope.editMode = true;
        $scope.addroleform.$setPristine(true);
        $('#roleModel').modal('show');
    };
    
    $scope.showDeleteModal = function(data) {
    	$scope.role = data;
        $('#confirmRoleModal').modal('show');
    };
    
    $scope.deleteRole= function() {
    	
//        $scope.employee = this.empleado;
        $http({method: 'POST', url: '/mymlogistica/role/delete', data:$scope.role}).
        success(function(data, status, headers, config) {
        	$scope.role = {};
        	$('#confirmRoleModal').modal('hide');
        	getRoles();
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
    };
   
    $scope.cancel = function () {
        $scope.role = {};
        $('#roleModel').modal('hide');
        getRoles();
    };
    
    function getRoles(){
    	$http({method: 'GET', url: '/mymlogistica/role/getRoles'}).
        success(function(data, status, headers, config) {
        	$scope.roles = data;
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
    }
    
    getRoles();
}]);



//******************** Activity Controller **************************************//

app.controller("ActivityController", ['$scope', '$http', function($scope, $http) {
	$scope.role = null;
	$scope.addActivity = function() {
		delete $scope.activityCtrl.roles;
		$http({method: 'POST', url: '/mymlogistica/activity/add', data:$scope.activityCtrl}).
        success(function(data, status, headers, config) {
        	$scope.activityCtrl = {};
        	$('#activityModel').modal('hide');
        	getRoles();
        	getActividades();
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
		
      };
      
      $scope.updateActivity = function() {
  		$http({method: 'PUT', url: '/mymlogistica/activity/update', data:$scope.roleCtrl.role}).
          success(function(data, status, headers, config) {
          	$scope.roleCtrl.role = {};
          	$('#roleModel').modal('hide');
          	getRoles();
          }).
          error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            status;
          });
  		
        };
    
    $scope.showActivityModal = function() {
        $scope.activityCtrl = {};
        $scope.editMode = false;
        $scope.activityCtrl.rolActividadList = [];
        getRoles();
        $scope.addactivityform.$setPristine(true);
        $('#activityModel').modal('show');
    };

    $scope.editarModal = function() {
        $scope.activityCtrl = this.actividad;
        $scope.editMode = true;
        $scope.activityCtrl.rolActividadList = {};
        getRoles();
        $scope.activityCtrl.rolActividadList = [ $scope.activityCtrl.roles[0] ];
        $scope.addactivityform.$setPristine(true);
        $('#activityModel').modal('show');
    };
    
    $scope.showDeleteModal = function(data) {
    	$scope.activityCtrl = data;
        $('#confirmActivityModal').modal('show');
    };
    
    $scope.deleteActividad= function() {
    	
//        $scope.employee = this.empleado;
        $http({method: 'POST', url: '/mymlogistica/activity/delete', data:$scope.activityCtrl}).
        success(function(data, status, headers, config) {
        	$scope.activityCtrl = {};
        	$('#confirmActivityModal').modal('hide');
        	getActividades();
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
    };
   
    $scope.cancel = function () {
        $scope.activityCtrl = {};
        $('#activityModel').modal('hide');
        getRoles();
    };
    
    function getRoles(){
    	$http({method: 'GET', url: '/mymlogistica/role/getRoles'}).
        success(function(data, status, headers, config) {
        	$scope.activityCtrl.roles = data;
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
    }
    
    function getActividades(){
    	$http({method: 'GET', url: '/mymlogistica/activity/getActividades'}).
        success(function(data, status, headers, config) {
        	$scope.actividades = data;
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
          status;
        });
    }
    
    getActividades();
}]);

})();