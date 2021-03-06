
/**
 * Created by chen_rj on 2017/7/3.
 */
define(function (require) {
    var Config = require('config');
    var Core = require('core/core');
    var Page = require('core/page');

    // 挂起
    var EditVariable = Page.extend(function () {
        var _self = this;


        // @override
        this.load = function(panel, data) {
            var form = panel.find('form');
                form.form('load', data)
                    .form('disableValidation')
                    .form('focus');
        };

        this.submit = function(panel, data, closeCallback) {
            var form = panel.find('form');
            form.form('enableValidation');
            var isValid = form.form('validate');
            var value=form.form('value');
            var flowInstId=this.parent.data.flowInstId;
            var varName=value.varName;
            var varValue=value.varValue;
            var runToken=value.runToken;
            if (isValid) {
                form.form('ajax', {
                    url: Config.ContextPath + 'workflow/flow/manager/savevariable/' + flowInstId + '/'+ varName+ '/'+varValue+'?runToken='+runToken,
                    method: 'get',
                }).then(closeCallback);
            }

            return false;
        };

        // @override
        this.onClose = function(table) {
            var flowInstId=this.parent.data.flowInstId;
            Core.ajax(Config.ContextPath+'workflow/flow/manager/getvariablelist/'+flowInstId, {
                method: 'get'
            }).then(function(data) {
                table.cdatagrid({
                    controller: _self
                })
                    .datagrid('loadData', data);
            });
        };
        // this.renderButton = function (btn, data) {
        //     if(data.instState == 'N')
        //         return true;
        //     return false;
        // };
    });
    return EditVariable;
});
