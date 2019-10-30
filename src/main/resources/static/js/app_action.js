Method.submit = function (button) {
    if (!button.up('panel').getForm().isValid()) {
        return;
    }

    App.processBar.show();
    var jsonData = button.up('panel').getForm().getFieldValues();

    Ext.Ajax.request({
        headers: {'Content-Type': 'Application/json'},
        url: '/post/form',
        method: 'POST',
        params: Ext.util.JSON.encode(jsonData),

        success: function (rsp, opts) {
            var obj = Ext.decode(rsp.responseText);
            console.dir(obj);
            App.processBar.hide();
            button.up('panel').getForm().reset();
            window.open(obj.data, '_blank')
        },

        failure: function (rsp, opts) {
            App.processBar.hide();
            console.log('server-side failure with status code ' + rsp.status);
        }
    });
};