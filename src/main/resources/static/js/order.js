$(document).ready(function() {

    getRequest("/order/getDailySales",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function (item) {
                return item.date;
            })
            var tableData = dataset.map(function (item) {
                return item.num;
            })
            var ctx = document.getElementById("orderDailySales");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: '订单销量',
                        data: tableData,
                        backgroundColor: window.chartColors.red,
                        borderColor: window.chartColors.red,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '订单日销表'
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
                                labelString: '销量'
                            }
                        }]
                    }
                }
            });
        })
    getRequest("/order/getWeeklySales",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function (item) {
                return item.beginDate + " ~ " + item.endDate;
            })
            var tableData = dataset.map(function (item) {
                return item.num;
            })
            var ctx = document.getElementById("orderWeeklySales");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: '订单销量',
                        data: tableData,
                        backgroundColor: window.chartColors.blue,
                        borderColor: window.chartColors.blue,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '订单周销表'
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
                                labelString: '销量'
                            }
                        }]
                    }
                }
            });
        })
    getRequest("/order/getDailyMoney",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function (item) {
                return item.date;
            })
            var tableData = dataset.map(function (item) {
                return (item.amount).toFixed(2);
            })
            var ctx = document.getElementById("orderDailyMoney");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: '订单金额',
                        data: tableData,
                        backgroundColor: window.chartColors.red,
                        borderColor: window.chartColors.red,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '订单日金额表'
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
                                labelString: '金额'
                            }
                        }]
                    }
                }
            });
        })
    getRequest("/order/getWeeklyMoney",
        function (res) {
            var dataset = res.content;
            var tableLabels = dataset.map(function (item) {
                return item.beginDate + " ~ " + item.endDate;
            })
            var tableData = dataset.map(function (item) {
                return (item.amount).toFixed(2);
            })
            var ctx = document.getElementById("orderWeeklyMoney");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: tableLabels,
                    datasets: [{
                        label: '订单金额',
                        data: tableData,
                        backgroundColor: window.chartColors.blue,
                        borderColor: window.chartColors.blue,
                        fill: false
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '订单周金额表'
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
                                labelString: '金额'
                            }
                        }]
                    }
                }
            });
        })
})