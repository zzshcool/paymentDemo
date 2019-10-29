Ext.application({
    name: 'PaymentApp',
    launch: function () {

        var linePayForm = Ext.create('Ext.form.Panel', {
            title: 'Line Pay',
            bodyPadding: 10,
            layout: 'vbox',
            items: [
                {
                    xtype: 'textfield',
                    fieldLabel: '商品名稱',
                    allowBlank: false,
                    name: 'productName'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: '商品圖片路徑',
                    name: 'productImageUrl'
                },
                {
                    xtype: 'numberfield',
                    hideTrigger: true,
                    allowBlank: false,
                    keyNavEnabled: false,
                    mouseWheelEnabled: false,
                    fieldLabel: '商品價格',
                    name: 'price'
                }, {
                    xtype: 'hiddenfield',
                    name: 'payCompany',
                    value: 'linepay'
                },
                {
                    xtype: 'button',
                    text: '提交',
                    handler: function () {

                        if (!this.up('panel').getForm().isValid()) {
                            return;
                        }

                        var jsonData = this.up('panel').getForm().getFieldValues();
                        console.log(jsonData);
                        console.log(Ext.util.JSON.encode(jsonData));
                        Ext.Ajax.request({
                            headers: {'Content-Type': 'application/json'},
                            url: '/post/form',
                            method: 'POST',
                            params: Ext.util.JSON.encode(jsonData),
                            success: function (rsp, opts) {
                                var obj = Ext.decode(rsp.responseText);
                                console.dir(obj)
                            },

                            failure: function (rsp, opts) {
                                console.log('server-side failure with status code ' + rsp.status);
                            }
                        });
                    }
                }
            ]
        });

        var allPayForm = Ext.create('Ext.form.Panel', {
            title: '歐付寶',
            bodyPadding: 10,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: 'First Name',
                    name: 'firstName'
                },
                {
                    fieldLabel: 'Last Name',
                    name: 'lastName'
                }, {
                    xtype: 'hiddenfield',
                    name: 'payCompany',
                    value: 'allpay'
                },
                {
                    xtype: 'button',
                    text: '提交',
                    handler: function () {
                        alert('提交')
                    }
                }
            ]
        });

        var greenPayForm = Ext.create('Ext.form.Panel', {
            title: '綠界支付',
            bodyPadding: 10,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: 'First Name',
                    name: 'firstName'
                },
                {
                    fieldLabel: 'Last Name',
                    name: 'lastName'
                }, {
                    xtype: 'hiddenfield',
                    name: 'payCompany',
                    value: 'ecpay'
                },
                {
                    fieldLabel: 'Date of Birth',
                    name: 'birthDate'
                }, {
                    xtype: 'button',
                    text: '提交',
                    handler: function () {
                        alert('提交')
                    }
                }
            ]
        });

        var aliPayForm = Ext.create('Ext.form.Panel', {
            title: '支付寶',
            bodyPadding: 10,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: 'First Name',
                    name: 'firstName'
                },
                {
                    fieldLabel: 'Last Name',
                    name: 'lastName'
                }, {
                    xtype: 'hiddenfield',
                    name: 'payCompany',
                    value: 'alipay'
                },
                {
                    fieldLabel: 'Date of Birth',
                    name: 'birthDate'
                }, {
                    xtype: 'button',
                    text: '提交',
                    handler: function () {
                        alert('提交')
                    }
                }
            ]
        });

        Ext.create('Ext.TabPanel', {
            renderTo: document.body,
            fullscreen: true,
            defaults: {
                styleHtmlContent: true
            },
            items: [
                linePayForm,
                allPayForm,
                greenPayForm,
                aliPayForm
            ]

        });
    }
});