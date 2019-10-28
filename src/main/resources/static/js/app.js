Ext.application({
    name: 'PaymentApp',
    launch: function () {

        var linePayForm = Ext.create('Ext.form.Panel', {
            title: 'Line Pay',
            bodyPadding: 10,
            layout: 'vbox',
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '商品名稱',
                    name: 'merchantName'
                },
                {
                    fieldLabel: '商品圖片',
                    name: 'merchantImage'
                },
                {
                    fieldLabel: '商品價格',
                    name: 'merchantPrice'
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