$(function () {
        //添加、修改异步提交地址
        var url = "";

        var tables = $("#dataTable").dataTable({
            serverSide: true,//分页，取数据等等的都放到服务端去
            processing: true,//载入数据的时候是否显示“载入中”
            pageLength: 10,  //首次加载的数据条数
            ordering: false, //排序操作在服务端进行，所以可以关了。
            pagingType: "full_numbers",
            autoWidth: false,
            stateSave: true,//保持翻页状态，和comTable.fnDraw(false);结合使用
            searching: false,//禁用datatables搜索
            ajax: {   
                type: "post",
                url: "rolePrivilege/list",
                dataSrc: "data",
                   data: function (d) {
                       var param = {};
                       param.draw = d.draw;
                       param.start = d.start;
                       param.length = d.length;
                       var formData = $("#queryForm").serializeArray();//把form里面的数据序列化成数组
                       formData.forEach(function (e) {
                           param[e.name] = e.value;
                       });
                        return param;//自定义需要传递的参数。
                },
            },
            columns: [//对应上面thead里面的序列
                {"data": null,"width":"10px"},
                {"data": null},
                {"data": 'id' },
                {"data": 'privilege.name' },
                {"data": null,"width":"30px"}
            ],
            //操作按钮
            columnDefs: [
                {
                 targets: 0,
                 defaultContent: "<input type='checkbox' name='checkList'>"
             },
             {
                 targets: -1,
                 defaultContent: "<div class='btn-group'>"+
                                "<button id='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i></button>"+
                                "</div>"
             }
            ],
            language: {
                lengthMenu: "",
                processing: "加载中",
                paginate: {
                    previous: "上一页",
                    next: "下一页",
                    first: "首页",
                    last: "末页"
                },
                zeroRecords: "暂无数据",
                info: "总页数：_PAGES_页，总数据：_TOTAL_条",
                infoEmpty: "",
                infoFiltered: "",
                sSearch: "关键词：",
            },
            //在每次table被draw完后回调函数
            fnDrawCallback: function(){
                var api = this.api();
                //获取到本页开始的条数
		            　　  var startIndex= api.context[0]._iDisplayStart;
		            　　  api.column(1).nodes().each(function(cell, i) {
		            　　　　    cell.innerHTML = startIndex + i + 1;
		            　　 }); 
            }
        });

        //查询按钮
        $("#btn-query").on("click", function () {
            tables.fnDraw();//查询后不需要保持分页状态，回首页
        });

        //添加
        $("#btn-add").on("click", function () {
            url = "rolePrivilege/add";
            $.ajax({
                url:'rolePrivilege/select',
                type:'post',
                dataType: "json",
                success:function(data){
                	$("#privilegeList2").empty();
                	$.each(data, function(idx, privilege){  
        				$("#privilegeList2").append("<option value='"+ privilege.id +"'>" + privilege.name + "</option>"); 
                    });
                },
                error:function(err){
                    alert("Server Connection Error...");
                }
            });
            $("#editModal").modal("show");
        });

        //导出
        $("#btn-export").on("click", function () {
        });

        //刷新
        $("#btn-re").on("click", function () {
            tables.fnDraw(false);//刷新保持分页状态
        });

        //checkbox全选
        $("#checkAll").on("click", function () {
            if ($(this).prop("checked") === true) {
                $("input[name='checkList']").prop("checked", $(this).prop("checked"));
                //$("#dataTable tbody tr").addClass('selected');
                $(this).hasClass('selected')
            } else {
                $("input[name='checkList']").prop("checked", false);
                $("#dataTable tbody tr").removeClass('selected');
            }
        });


        $("#btn-submit").on("click", function(){
            $.ajax({
              type: "POST",
              url: url,
              data: $("#editForm").serialize(),
              error: function(request) {
                  alert("Server Connection Error...");
              },
              success: function(data) {
                if(data == "success"){
                    $("#editModal").modal("hide");
                    tables.fnDraw();
                }else{
                    alert("操作失败");
                }
              }
          });
        });

        //删除
        $("#dataTable tbody").on("click", "#delRow", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            if(confirm("是否确认删除这条信息?")){
                $.ajax({
                    url:'rolePrivilege/delete',
                    type:'post',
                    data: {
                    	"id" : data.id
                    },
                    dataType: "json",
                    cache: "false",
                    success:function(data){
                        if(data == "success"){
                            tables.api().row().remove().draw(false);
                        }else{
                            alert("删除失败");
                        }
                    },
                    error:function(err){
                        alert("Server Connection Error...");
                    }
                });
            }
        });
    });