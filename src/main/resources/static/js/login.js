let login_app = new Vue({
    el: "#login",
    data: {
        username: "",
        password: "",
    },
    methods: {
        login: function (event) {
            let formData = new FormData(event.target);
            //根据后台接收参数格式进行修改
            let config = {
                headers: {
                    // 默认值
                    'Content-Type': 'application/json'
                }
            };
            let jsonData = {};
            formData.forEach((value, key) => jsonData[key] = value);
            jsonData.password = CryptoJS.MD5(this.password).toString();
            axios.post(context + "loginUser", jsonData, config).then(res => {
                res.data.status ? window.location.href = context + this.username : layer.alert(res.data.t);
            }).catch(err => {
                console.log(err);
            });
        }
    }
});