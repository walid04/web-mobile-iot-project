var app = new Vue({
    el: '#getBuildings',
    data () {
        return {
            buildings: null,
        }
    },
    mounted () {
        this.getFunction()
    },
    methods: {
        getFunction () {
            axios
                .get('http://localhost:8080/api/buildings')
                .then(response => (this.buildings = response.data))
        },
        //function to auto resfresh
        autoRefresh () {
            setInterval(() => {
                this.getFunction();
            }, 2000);
        }
    }
})