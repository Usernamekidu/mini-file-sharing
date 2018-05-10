app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "app/user/table_index.html"
        })
        .when("/upload", {
            templateUrl: "app/user/upload.html"
        })
        .when("/file_management", {
            templateUrl: "app/user/file_management.html"
        })
        .when("/file_information", {
            templateUrl: "app/user/file_information.html"
        });
});