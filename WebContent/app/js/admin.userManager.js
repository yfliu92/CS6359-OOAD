(function ($, window, document) {
    var addUserBtn = ".add-user-btn";
    var addUserFormArea = "#add-user-form-area";

    var $ADD_USER_BTN = $(addUserBtn);
    var $ADD_USER_FORM_AREA = $(addUserFormArea);

    function showAdd() {
        $ADD_USER_FORM_AREA.css("display", "block");
    }

    $(function () {
        $('.admin-users').addClass('active');

        $ADD_USER_BTN.click(showAdd);
    });
})(window.jQuery, window, document);
