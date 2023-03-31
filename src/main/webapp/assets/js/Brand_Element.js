const app = Vue.createApp({
    data(){

        return{
            username:"",
            multipleSelection: [],
            selectIds: [],

            tableData: [],
            editBrandFormVisible: false,
            brand_form: {
                id:"",
                brandName: "",
                companyName: "",
                ordered: "",
                status:0,
                description: "",
            },
            pages:{
              currentpage:1,
              pagesize:10,
                searchdata: {
                    brandName: "",
                    companyName: "",
                    status:""
                },
            },
            searchForm: {
                brandName: "",
                companyName: "",
                status:""
            },
            deleteone:0,
            brandFormWidth:"80px",
            totalRowInPages:2000,
            pageSizes:[10,20,50,100,200,400,500,600,800,1000]
        }
    },
    methods:{
        getusername(){
            axios.get("http://localhost:8080/VueElement_practice_war/User/loginState").then(
                resp=>(this.username=resp.data)
            )
        },

        tableRowClassName({row, rowIndex}) {
            if ((rowIndex%3) === 0) {
                return "warning-row";
            } else if ((rowIndex%3) === 1) {
                return "success-row";
            }
            return "";
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        brandSearch_Submit() {
            this.pages.searchdata.brandName=this.searchForm.brandName;
            this.pages.searchdata.companyName=this.searchForm.companyName;
            this.pages.searchdata.status=this.searchForm.status;
            this.selectByPage();
        },
        handleSizeChange(val) {
            this.pages.pagesize=val;
            this.selectByPage();
        },
        handleCurrentChange(val) {
            this.pages.currentpage=val;
            this.selectByPage();
        },
        editBrandSubmit(){
            if(this.brand_form.id >0){
                axios.post("http://localhost:8080/VueElement_practice_war/Brand/Update",this.brand_form).then(
                    resp=>{
                        if(resp.data=="success"){
                            this.editBrandFormVisible = false;
                            this.$message({
                                message: "修改成功",
                                type: "success"
                            });
                            this.cleanrForm();
                            this.selectByPage();
                        }
                    }
                )
            }else{
                axios.post("http://localhost:8080/VueElement_practice_war/Brand/Insert",this.brand_form).then(
                    resp=>{
                        if(resp.data=="success"){
                            this.editBrandFormVisible = false;
                            this.$message({
                                message: "新增成功",
                                type: "success"
                            });
                            this.cleanrForm();
                            this.selectByPage();
                        }
                    }
                )
            }
        },
        editBrandCancle(){
            // this.brand_form.resetFields();
            this.cleanrForm();
            this.editBrandFormVisible = false;
        },
        selectByPage(){
            axios.post("http://localhost:8080/VueElement_practice_war/Brand/selectByPageAndCondition",this.pages).then(
                resp=>{
                    this.tableData=resp.data.datalist;
                    this.totalRowInPages=resp.data.totalRowInPages;
                }
            )
        },
        editdata(rowdata){
            this.brand_form.id=rowdata.id;
            this.brand_form.brandName=rowdata.brandName;
            this.brand_form.companyName=rowdata.companyName;
            this.brand_form.ordered=rowdata.ordered;
            this.brand_form.description=rowdata.description;
            this.brand_form.status=rowdata.status;
            console.log(this.brand_form.status);
            this.editBrandFormVisible = true
        },
        deletebyid(rowdata){
            this.deleteone=1;
            this.selectIds=[rowdata.id];
            this.deleteByIds();
            this.deleteone=0;
        },
        cleanrForm(){
            this.brand_form.id="";
            this.brand_form.brandName="";
            this.brand_form.companyName="";
            this.brand_form.ordered="";
            this.brand_form.description="";
            this.brand_form.status=0;
        }
        ,
        deleteByIds(){
            this.$confirm("此操作將永久刪除該數據，是否繼續？", "確認刪除數據？", {
                    confirmButtonText: "確定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    if(this.deleteone===0){
                        for(let i=0;i<this.multipleSelection.length;i++){
                            this.selectIds[i]=this.multipleSelection[i].id;
                        }
                    }
                    axios.post("http://localhost:8080/VueElement_practice_war/Brand/DeleteByIds",this.selectIds).then(
                        resp=>{
                            if(resp.data=="success"){
                                this.$message({
                                    message: "刪除成功",
                                    type: "success"
                                });
                                this.selectByPage();
                            }
                        }
                    )
                    }).catch(() => {
                        this.$message({
                                type: "info",
                                message: "取消刪除"
                        });
                    });
        }
    },
    mounted(){
        this.getusername();
        this.selectByPage();
    }
});

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component);
}
// app.use(ElementPlus);
app.use(ElementPlus, {
    locale: ElementPlusLocaleZhTw,
});
app.mount("#app");