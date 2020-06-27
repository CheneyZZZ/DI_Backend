$(document).ready(function() {

    getRequest("/flow/getUserActive",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function(item){
                return item.date;
            })
            var tableData = dataset.map(function(item) {
                return item.num;
            })
            var ctx = document.getElementById("flowUserActive");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: '用户数',
                        data: tableData,
                        backgroundColor: window.chartColors.red,
                        borderColor:window.chartColors.red,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '用户日活表'
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    },
                    scales: {
                        xAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '日期'
                            }
                        }],
                        yAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '访问人数'
                            }
                        }]
                    }
                }
            });
        })

    getRequest("/flow/getActiveEvent",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function (item) {
                return item.date;
            })
            var tableDataView = dataset.map(function (item) {
                return item.view;
            })
            var tableDataCart = dataset.map(function (item) {
                return item.cart;
            })
            var tableDataBuy = dataset.map(function (item) {
                return item.buy;
            })
            var ctx = document.getElementById("flowActiveEvent").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: 'view',
                        data: tableDataView,
                        backgroundColor: window.chartColors.blue
                    },{
                        label: 'cart',
                        data: tableDataCart,
                        backgroundColor: window.chartColors.red
                    },{
                        label: 'buy',
                        data: tableDataBuy,
                        backgroundColor: window.chartColors.green
                    }]
                },
                options: {
                    title: {
                        display: true,
                        text: '活跃事件表'
                    },
                    tooltips: {
                        mode: 'index',
                        intersect: false
                    },
                    responsive: true,
                    scales: {
                        xAxes: [{
                            stacked: true,
                        }],
                        yAxes: [{
                            stacked: true
                        }]
                    }
                }
            })
        })

    getRequest("/flow/getEventRatio",function (res) {
        var data = res.content;
        var tableLabels = ['0-1','1-2','2-3','3-4','4-5','5-10','10-'];
        var tableDataFemaleViewBuy = [0,0,0,0,0,0,0];
        var tableDataMaleViewBuy = [0,0,0,0,0,0,0];
        var tableDataFemaleViewCart = [0,0,0,0,0,0,0];
        var tableDataMaleViewCart = [0,0,0,0,0,0,0];
        var tableDataFemaleCartBuy = [0,0,0,0,0,0,0];
        var tableDataMaleCartBuy = [0,0,0,0,0,0,0];
        var femaleViewBuyAverage = 0;
        var femaleViewCartAverage = 0;
        var femaleCartBuyAverage = 0;
        var maleViewBuyAverage = 0;
        var maleViewCartAverage = 0;
        var maleCartBuyAverage = 0;
        var femaleSum = 0;
        var maleSum = 0;
        data.forEach(function (item) {
            if(item.gender==0){
                maleSum++;
                maleViewBuyAverage += item.view_buy;
                maleViewCartAverage += item.view_cart;
                maleCartBuyAverage += item.cart_buy;
                if(item.view_cart>=0&&item.view_cart<1){
                    tableDataMaleViewCart[0]++;
                }else if(item.view_cart>=1&&item.view_cart<2){
                    tableDataMaleViewCart[1]++;
                }else if(item.view_cart>=2&&item.view_cart<3){
                    tableDataMaleViewCart[2]++;
                }else if(item.view_cart>=3&&item.view_cart<4){
                    tableDataMaleViewCart[3]++;
                }else if(item.view_cart>=4&&item.view_cart<5){
                    tableDataMaleViewCart[4]++;
                }else if(item.view_cart>=5&&item.view_cart<10){
                    tableDataMaleViewCart[5]++;
                }else{
                    tableDataMaleViewCart[6]++;
                }

                if(item.view_buy>=0&&item.view_buy<1){
                    tableDataMaleViewBuy[0]++;
                }else if(item.view_buy>=1&&item.view_buy<2){
                    tableDataMaleViewBuy[1]++;
                }else if(item.view_buy>=2&&item.view_buy<3){
                    tableDataMaleViewBuy[2]++;
                }else if(item.view_buy>=3&&item.view_buy<4){
                    tableDataMaleViewBuy[3]++;
                }else if(item.view_buy>=4&&item.view_buy<5){
                    tableDataMaleViewBuy[4]++;
                }else if(item.view_buy>=5&&item.view_buy<10){
                    tableDataMaleViewBuy[5]++;
                }else{
                    tableDataMaleViewBuy[6]++;
                }

                if(item.cart_buy>=0&&item.cart_buy<1){
                    tableDataMaleCartBuy[0]++;
                }else if(item.cart_buy>=1&&item.cart_buy<2){
                    tableDataMaleCartBuy[1]++;
                }else if(item.cart_buy>=2&&item.cart_buy<3){
                    tableDataMaleCartBuy[2]++;
                }else if(item.cart_buy>=3&&item.cart_buy<4){
                    tableDataMaleCartBuy[3]++;
                }else if(item.cart_buy>=4&&item.cart_buy<5){
                    tableDataMaleCartBuy[4]++;
                }else if(item.cart_buy>=5&&item.cart_buy<10){
                    tableDataMaleCartBuy[5]++;
                }else{
                    tableDataMaleCartBuy[6]++;
                }
            }else{
                femaleSum++;
                femaleViewBuyAverage += item.view_buy;
                femaleViewCartAverage += item.view_cart;
                femaleCartBuyAverage += item.cart_buy;
                if(item.view_cart>=0&&item.view_cart<1){
                    tableDataFemaleViewCart[0]++;
                }else if(item.view_cart>=1&&item.view_cart<2){
                    tableDataFemaleViewCart[1]++;
                }else if(item.view_cart>=2&&item.view_cart<3){
                    tableDataFemaleViewCart[2]++;
                }else if(item.view_cart>=3&&item.view_cart<4){
                    tableDataFemaleViewCart[3]++;
                }else if(item.view_cart>=4&&item.view_cart<5){
                    tableDataFemaleViewCart[4]++;
                }else if(item.view_cart>=5&&item.view_cart<10){
                    tableDataFemaleViewCart[5]++;
                }else{
                    tableDataFemaleViewCart[6]++;
                }

                if(item.view_buy>=0&&item.view_buy<1){
                    tableDataFemaleViewBuy[0]++;
                }else if(item.view_buy>=1&&item.view_buy<2){
                    tableDataFemaleViewBuy[1]++;
                }else if(item.view_buy>=2&&item.view_buy<3){
                    tableDataFemaleViewBuy[2]++;
                }else if(item.view_buy>=3&&item.view_buy<4){
                    tableDataFemaleViewBuy[3]++;
                }else if(item.view_buy>=4&&item.view_buy<5){
                    tableDataFemaleViewBuy[4]++;
                }else if(item.view_buy>=5&&item.view_buy<10){
                    tableDataFemaleViewBuy[5]++;
                }else{
                    tableDataFemaleViewBuy[6]++;
                }

                if(item.cart_buy>=0&&item.cart_buy<1){
                    tableDataFemaleCartBuy[0]++;
                }else if(item.cart_buy>=1&&item.cart_buy<2){
                    tableDataFemaleCartBuy[1]++;
                }else if(item.cart_buy>=2&&item.cart_buy<3){
                    tableDataFemaleCartBuy[2]++;
                }else if(item.cart_buy>=3&&item.cart_buy<4){
                    tableDataFemaleCartBuy[3]++;
                }else if(item.cart_buy>=4&&item.cart_buy<5){
                    tableDataFemaleCartBuy[4]++;
                }else if(item.cart_buy>=5&&item.cart_buy<10){
                    tableDataFemaleCartBuy[5]++;
                }else{
                    tableDataFemaleCartBuy[6]++;
                }
            }
        })
        tableDataMaleViewBuy=tableDataMaleViewBuy.map(function (a) {
            return (a*100/maleSum).toFixed(2);
        })
        tableDataMaleViewCart=tableDataMaleViewCart.map(function (a) {
            return (a*100/maleSum).toFixed(2);
        })
        tableDataMaleCartBuy = tableDataMaleCartBuy.map(function (a) {
            return (a*100/maleSum).toFixed(2);
        })
        tableDataFemaleViewBuy = tableDataFemaleViewBuy.map(function (a) {
            return (a*100/femaleSum).toFixed(2);
        })
        tableDataFemaleViewCart = tableDataFemaleViewCart.map(function (a) {
            return (a*100/femaleSum).toFixed(2);
        })
        tableDataFemaleCartBuy = tableDataFemaleCartBuy.map(function (a) {
            return (a*100/femaleSum).toFixed(2);
        })
        femaleViewBuyAverage /= femaleSum;
        femaleViewCartAverage /= femaleSum;
        femaleCartBuyAverage /= femaleSum;
        maleViewBuyAverage /= maleSum;
        maleViewCartAverage /= maleSum;
        maleCartBuyAverage /= maleSum;
        var ctx = document.getElementById("flowUserRatio");
        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: tableLabels,
                datasets: [{
                    label: '女性view-cart比率',
                    data: tableDataFemaleViewCart,
                    backgroundColor: window.chartColors.blue,
                    borderColor: window.chartColors.blue,
                    fill: false
                },{
                    label: '女性view-buy比率',
                    data: tableDataFemaleViewBuy,
                    backgroundColor: window.chartColors.red,
                    borderColor: window.chartColors.red,
                    fill: false
                },{
                    label: '女性cart-buy比率',
                    data: tableDataFemaleCartBuy,
                    backgroundColor: window.chartColors.green,
                    borderColor: window.chartColors.green,
                    fill: false
                },{
                    label: '男性view-cart比率',
                    data: tableDataMaleViewCart,
                    backgroundColor: window.chartColors.grey,
                    borderColor: window.chartColors.grey,
                    fill: false
                },{
                    label: '男性view-buy比率',
                    data: tableDataMaleViewBuy,
                    backgroundColor: window.chartColors.purple,
                    borderColor: window.chartColors.purple,
                    fill: false
                },{
                    label: '男性cart-buy比率',
                    data: tableDataMaleCartBuy,
                    backgroundColor: window.chartColors.orange,
                    borderColor: window.chartColors.orange,
                    fill: false
                }]
            },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: '用户行为比率'
                },
                hover: {
                    mode: 'nearest',
                    intersect: true
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: '区间'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: '百分比%'
                        }
                    }]
                }
            }
        })
    })
})

