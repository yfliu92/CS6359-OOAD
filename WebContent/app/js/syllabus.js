$(document).ready(function () {
    var syllabus_id=$("#syllabus_id").attr("value");
    $("#syllabus_id").before("<p>"+syllabus_id+"</p>");
    loading(syllabus_id);
    $("#submit").click(function () {
        update(syllabus_id);
    });
});
function loading(syllabus_id){
    $.ajax({
        url: "syllabusController",
        data: {"op":"syllabusDetail", "syllabusId":syllabus_id},
        async: false,
        success:function (data) {
            var jsonObject=$.parseJSON(data);
            $("#description").val(jsonObject.description);
            $("#grading").val(jsonObject.grading);
            $("#taName").val(jsonObject.taName);
            $("#taEmail").val(jsonObject.taEmail);
            // $(location).attr("href","app/teacher/Syllabus.jsp");
        },
        error: function () {
            alert("error loading file");
        }
    });
}
function update(syllabus_id) {
    var  description=$("#description").val();
    var  taName=$("#taName").val();
    var  taEmail=$("#taEmail").val();
    var  grading=$("#grading").val();

    $.ajax({
        url: "syllabusController",
        data: {"op":"update", "syllabusId":syllabus_id,"description":description, "taName":taName,"taEmail":taEmail,"grading":grading},
        async: false,
        success:function (data) {
            var jsonObject=$.parseJSON(data);
            if(jsonObject.status==0){
                alert("failed");
            }
            else{
                $(location).attr("href","app/teacher/teacher.jsp");
            }
            // $(location).attr("href","app/teacher/Syllabus.jsp");
        },
        error: function () {
            alert("error loading file");
        }
    });
}