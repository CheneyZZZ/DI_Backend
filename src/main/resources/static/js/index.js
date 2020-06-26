function getRequest(url, onSuccess, onError) {
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        success: onSuccess,
        error: onError
    });
}
window.chartColors = {
    red: 'rgb(255, 99, 132)',
    orange: 'rgb(255, 159, 64)',
    yellow: 'rgb(255, 205, 86)',
    green: 'rgb(75, 192, 192)',
    blue: 'rgb(54, 162, 235)',
    purple: 'rgb(153, 102, 255)',
    grey: 'rgb(201, 203, 207)'
};
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
                        x: {
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '日期'
                            }
                        },
                        y: {
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: '访问人数'
                            }
                        }
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
})

