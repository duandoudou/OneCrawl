<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
    <title>编辑任务</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta name="MobileOptimized" content="320">
    <link rel="shortcut icon" href="favicon.ico"/>
    <link href="/static/pagurain/resources/css/public.css" rel="stylesheet" type="text/css"/>
    <link id="style_themes" href="/static/pagurain/resources/css/themes-green.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="/static/css/highlight.default.min.css">

    <!--[if lt IE 9]>
    <script src="/static/js/es5-shim.min.js"></script>
    <![endif]-->
    <!--[if !IE]><!-->
    <script src="/static/js/highlight.min.js"></script>
    <!--<![endif]-->


</head>
<body>

<#include "../header.ftl">
<div class="clearfix"></div>

<!-- BEGIN CONTAINER -->
<div class="page-container">
<#include "../left.ftl">


    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">

            <div class="row">
                <div class="col-md-12">

                    <form action="#" id="dataForm">
                        <div class="form-body">

                            <div class="form-group">
                                <label>id</label>
                                <div>
                                    <input type="text" name="id" disabled data-required="1" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label>name</label>
                                <div>
                                    <input type="text" name="name" data-required="1" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label>状态</label>
                                <div>
                                    <input type="text" name="status" disabled data-required="1" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label>创建时间</label>
                                <div>
                                    <input type="text" name="createTime" disabled data-required="1" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label>下次运行时间</label>
                                <div>
                                    <input type="text" name="nextRunTime" disabled data-required="1" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label>周期</label>
                                <div>
                                    <input type="number" name="cycle" data-required="1" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label>线程数</label>
                                <div>
                                    <input type="number" name="threadNum" data-required="1" class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label>是否使用代理</label>
                                <div class="radio-list">
                                    <label class="radio-inline">
                                        <input type="radio" name="proxy" value="1"> 使用
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="proxy" value="2"> 不使用
                                    </label>
                                </div>
                                <span for="proxy"  class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label>是否使用 JS 引擎</label>
                                <div class="radio-list">
                                    <label class="radio-inline">
                                        <input type="radio" name="javascript" value="1"> 使用
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="javascript" value="2"> 不使用
                                    </label>
                                </div>
                                <span for="javascript"  class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label>链接</label>
                                <div>
                                    <textarea name="url" class="form-control"></textarea>
                                </div>
                                <span for="url"  class="help-block tip" data-tip="该字段不能大于10个字符" ></span>
                            </div>
                            <div class="form-group">
                                <label>Select</label>

                                <select name="select" class="form-control">
                                    <option value="">select...</option>
                                    <option value="1">一</option>
                                    <option value="2">二</option>
                                    <option value="3">三</option>
                                    <option value="4">四</option>
                                    <option value="6">五</option>
                                </select>

                            </div>
                        </div>
                        <div class="form-actions">
                            <button type="button" id="btn_submit" class="btn green">Submit</button>
                            <button type="button" class="btn default">Cancel</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>

    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<div id="descrView"></div>

<script src="/static/pagurain/pagurian.js"></script>

<!--[if lt IE 9]>
<script src="/static/js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
    //    window.CONFIG = {
    //        appId: "uploader"
    //    };
</script>
<script type="text/javascript">
    var dataTable;
    pagurian.call("modules/form/app", function (app) {
        $p.com.form("#dataForm", {
            //表单验证
            validate: {
                rules: {
                    name: {
                        maxlength: 128,
                        required: true,
                        validString: true
                    },
                    cycle: {
                        required: true,
                        number: true
                    },
                    threadNum: {
                        required: true,
                        number: true
                    },
                    proxy: {
                        required: true
                    },
                    javascript: {
                        required: true
                    },
                    url: {
                        required: true,
                        validString: true
                    }
                },
                //自定义验证
                custom: function(data, $form) {

                    var $textarea = $form.find("[name='textarea']");
                    var $textareaBlock = $form.find(".help-block[for='textarea']");

                    if ($textarea.val().length > 10) {
                        $textareaBlock.html("该字段不能大于10个字符啊~~~").removeClass("tip");
                        return false;
                    }
                    return true;
                }
            },
            //提交按钮
            submitButton: "#btn_submit",
            //提交接口
            submitModelEvent: model.add,
            //接口参数
            submitModelParams: function(params, callback) {
                //新增参数项，回调函数
                return [params, callback];
            },
            //数据格式化
            submitDataFormat: function(data, form) {
                var _data = [];
                //格式化后的数据
                for (var i = 0; i < data.length; i++) {
                    if (data[i].name == 'checkbox') {
                        _data.push({
                            name: "checkboxes",
                            value: {
                                id: data[i].value,
                                title: data[i].name
                            },
                            //当checkbox只选中一项的时候,提交的时候会当做Object{}处理
                            //属性type: "array",是为了让该字段当做Array[]处理
                            type: "array"
                        });
                        continue;
                    }

                    _data.push(data[i]);
                }
                return _data;
            },
            //提交成功
            submitSuccess: function(resp, valid) {
                $p.alert(resp.message);
            },
            //提交失败
            submitError: function(resp, valid) {
                $p.alert(resp.message, "error");
            }
        });
    })
</script>

</body>
</html>
