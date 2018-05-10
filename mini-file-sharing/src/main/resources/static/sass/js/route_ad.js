app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "table_index_admin.html"
    })
    .when("/user_management", {
        templateUrl : "admin_CRUD_user.html"
    })
    .when("/category_management", {
        templateUrl : "admin_category.html"
    })
    .when("/upload_history", {
        templateUrl : "upload_history.html"
    })
    .when("/download_history", {
        templateUrl : "download_history.html"
    })
    .when("/view_user_information", {
        templateUrl : "admin_view_user_information.html"
    });
});