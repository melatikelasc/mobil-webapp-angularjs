var mblApp= angular.module('MblApp', []);

mblApp.controller('MblController', 
    function($scope, $http, $window) {
        $scope.daftarMbl = [];
        $scope.updateDaftarMbl = function(){
            $http.get('/daftar-mobil').then(sukses, gagal);
            
            function sukses(response){
            	console.log(response);
            	//isidata mahasiswa
            	$scope.daftarMbl = response.data;
            };
            function gagal(response){
            	console.log(response);
        	};
        };

        $scope.ubah = function(mbl){
            //console.log(mhs);
            $window.location.href="/form-edit?id=" + mbl.id;
        };
        
        $scope.hapus = function(mbl){
            $http.delete('/hapus-data/' + mbl.id).then(sukses, gagal);

            function sukses(response){
                $scope.updateDaftarMbl();
            } ;

            function gagal(response){
                console.log(response);
            } ;
        };

        $scope.keluar = function() {
            $http.get('/keluar').then(sukses, gagal);

            function sukses(response){
                $window.location.href="/";
                
                
            };
            function gagal(response){
                console.log(response);
            };
        

        };

        $scope.updateDaftarMbl();
    });
mblApp.controller('FormController', 
    function($scope, $http, $window){
        $scope.simpan = function() {
            //console.log('nim : '+ $scope.mhs.nim);
            //console.log('nama : '+ $scope.mhs.nama);
            //console.log('jurusan : '+ $scope.mhs.jurusan);

            $http.post('/tambah-mbl', $scope.mbl).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
        };

        $scope.batal = function() {
            $window.location.href = '/';
        };
    });