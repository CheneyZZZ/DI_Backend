$(document).ready(function() {
    getRequest("/user/getGenderRatio",
        function (res) {
            var dataset = res.content;
            var ctx = document.getElementById("userGenderRatio");
            var myChart = new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ["男","女"],
                    datasets: [{
                        data: [dataset.male,dataset.female],
                        backgroundColor:[
                            window.chartColors.red,
                            window.chartColors.blue,
                        ],
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: '用户男女数表'
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    },
                }
            });
        })

    getRequest("/user/getRegionList",
        function (res) {
            var dataset = res.content;
            var ctx = document.getElementById("userRegionList");
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: Object.keys(dataset),
                    datasets: [{
                        label: 'num',
                        data: Object.values(dataset),
                        backgroundColor: window.chartColors.blue
                    }],
                },
                options: {
                    title: {
                        display: true,
                        text: '用户地区分布表'
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
