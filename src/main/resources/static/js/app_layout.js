Ext.application({
    name: 'PaymentApp',
    launch: function () {

        App.linePayForm = Ext.create('Ext.form.Panel', {
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
                    text: submitText,
                    handler: function () {
                        Method.submit(this);
                    }
                }
            ]
        });

        App.allPayForm = Ext.create('Ext.form.Panel', {
            title: '歐付寶',
            bodyPadding: 10,
            items: [
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
                    value: 'allpay'
                },
                {
                    xtype: 'button',
                    text: submitText,
                    handler: function () {
                        Method.submit(this);
                    }
                }
            ]
        });

        App.greenPayForm = Ext.create('Ext.form.Panel', {
            title: '綠界支付',
            bodyPadding: 10,
            items: [
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
                    value: 'ecpay'
                },
                {
                    xtype: 'button',
                    text: submitText,
                    handler: function () {
                        Method.submit(this);
                    }
                }
            ]
        });

        App.aliPayForm = Ext.create('Ext.form.Panel', {
            title: '支付寶',
            bodyPadding: 10,
            items: [
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
                    value: 'alipay'
                },
                {
                    xtype: 'button',
                    text: submitText,
                    handler: function () {
                        Method.submit(this);
                    }
                }
            ]
        });

        App.mainPanel = Ext.create('Ext.TabPanel', {
            renderTo: document.body,
            fullscreen: true,
            defaults: {
                styleHtmlContent: true
            },
            items: [
                App.linePayForm,
                App.allPayForm,
                App.greenPayForm,
                App.aliPayForm
            ]
        });

        App.processBar = new Ext.LoadMask({
            msg: 'Please wait...',
            target: App.mainPanel
        });

    }
});


