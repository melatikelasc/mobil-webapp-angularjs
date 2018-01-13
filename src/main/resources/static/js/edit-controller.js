mblApp.controller('EditController',
	function($scope, $window, $http){


		$scope.mbl={};

		$scope.simpan = function() {
			$http.post('/tambah-mbl', $scope.mbl).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.batal = function() {
			$window.location.href = "/";
		};

		$scope.updateById = function() {
			id=$window.location.search.split('=')[1];
			//console.log(nim);
			$scope.mbl.id = id;

			$http.get("/get-mbl-by-id/" + id).then(sukses, gagal);

			function sukses(response){
                //$window.location.href = '/';
                $scope.mbl = response.data;
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.updateById();

	});