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
                    name: 'productName'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: '商品圖片路徑',
                    name: 'productImageUrl'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: '商品價格',
                    name: 'price'
                },
                {
                    xtype: 'combobox',
                    name: 'currency',
                    label: 'Choose Currency',
                    //queryMode: 'local',
                    displayField: 'name',
                    valueField: 'value',
                    // // For the dropdown list
                    // itemTpl: '<span role="option" class="x-boundlist-item">{abbr} - {name}</span>',
                    // // For the content of the text field
                    // displayTpl: '{abbr} - {name}',
                    editable: false,  // disable typing in the text field
                    store: [
                        {value: 'TWD', name: '台幣'},
                        {value: 'JPY', name: '日圓'},
                        {value: 'JPY', name: '人民幣 '},
                        {value: 'USD', name: '美元 '}
                    ]
                },
                {
                    xtype: 'button',
                    text: '提交',
                    handler: function () {
                        Ext.Ajax.request({
                            url: '/post/form',
                            method: 'POST',
                            params: {
                                bo: Ext.util.JSON.encode(this.up('panel').getForm().getFieldValues())
                            },
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