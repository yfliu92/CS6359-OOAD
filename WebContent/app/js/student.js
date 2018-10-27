(function ($, window, document) {

    var cform = "#cform";
    var detail_btn = ".detail-btn";
    var drop_btn = ".drop-btn";
    var reg_btn = ".reg-btn";
    var selectid_input = "#select-id-input";
    var op_input = "#op-input";


    var $CFORM = $(cform);
    var $DETAIL_BTN = $(detail_btn);
    var $SELECT_INPUT = $(selectid_input);
    var $OP_INPUT = $(op_input);
    var $DROP_BTN = $(drop_btn);
    var $REG_BTN = $(reg_btn);

    // jquery document ready
    $(function () {
        // display course details operation
        $CFORM.on('click', detail_btn, function (e) {
            e.preventDefault();

            var $TARGET = $(e.target);

            var id = $TARGET.attr("data-course-id");
            if (id !== "") {
                $SELECT_INPUT.attr("value", id);
                $OP_INPUT.attr("value", "show");
                $CFORM.submit();
            }
        });

        // drop operation
        $CFORM.on('click', drop_btn, function (e) {
            e.preventDefault();

            var $TARGET = $(e.target);

            var id = $TARGET.attr("data-course-id");
            if (id !== "") {
                $SELECT_INPUT.attr("value", id);
                $OP_INPUT.attr("value", "drop");

                var isConfirm = confirm("Click OK to Continue or Click Cancel to return");

                if (isConfirm) {
                    $CFORM.submit();
                } else {
                    return false;
                }

            }
        });

        // register course operation
        $CFORM.on('click', reg_btn, function (e) {
            e.preventDefault();

            var $TARGET = $(e.target);

            var id = $TARGET.attr("data-course-id");
            if (id !== "") {
                $SELECT_INPUT.attr("value", id);
                $OP_INPUT.attr("value", "register");
                $CFORM.submit();
            }
        });
    });

})(window.jQuery, window, document);
