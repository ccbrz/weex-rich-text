<template>
    <div>
    <cc-rich-text style="width:750;height:800" ref="richtext" @onLinkInsert="onLinkInsert" @onTableInsert="onTableInsert" @onColorSelected="onColorSelected" html="<p>hello world</p>"></cc-rich-text>
    <scroller style="top:800;width:750;position: absolute">
      <div>
        <button  @click="setBold" style="margin-top:20px;padding:25px;background-color:#e0ffff">加粗</button>
        <button  @click="setUnderline" style="margin-top:20px;padding:25px;background-color:#e0ffff">下划线</button>
        <button  @click="setDash" style="margin-top:20px;padding:25px;background-color:#e0ffff">中划线</button>
        <button  @click="removeFormat" style="margin-top:20px;padding:25px;background-color:#e0ffff">移除格式</button>
        <button  @click="setNormal" style="margin-top:20px;padding:25px;background-color:#e0ffff">正常字体</button>
        <button  @click="setH1" style="margin-top:20px;padding:25px;background-color:#e0ffff">H1</button>
        <button  @click="setH2" style="margin-top:20px;padding:25px;background-color:#e0ffff">H2</button>
        <button  @click="setH3" style="margin-top:20px;padding:25px;background-color:#e0ffff">H3</button>
        <button  @click="setH4" style="margin-top:20px;padding:25px;background-color:#e0ffff">H4</button>
        <button  @click="setH5" style="margin-top:20px;padding:25px;background-color:#e0ffff">H5</button>
        <button  @click="setH6" style="margin-top:20px;padding:25px;background-color:#e0ffff">H6</button>
        <button  @click="setSuperScript" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置上半区</button>
        <button  @click="setSubScript" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置下半区</button>
        <button  @click="setOrderWithPoint" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置子弹头列表</button>
        <button  @click="setOrderWithNumber" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置数字列表</button>
        <button  @click="setQuoteBlock" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置引用块</button>
        <button  @click="setCodeBlock" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置代码块</button>
        <button  @click="setAlignLeft" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置左对齐</button>
        <button  @click="setAlignRight" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置右对齐</button>
        <button  @click="setAlignCenter" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置居中对齐</button>
        <button  @click="setAlignJustify" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置双端对齐</button>
        <button  @click="setHorizontalDividingLine" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置横向分割线</button>
        <button  @click="setIndent" style="margin-top:20px;padding:25px;background-color:#e0ffff">设置一次缩进</button>
        <button  @click="setUnIndent" style="margin-top:20px;padding:25px;background-color:#e0ffff">取消一次缩进</button>
        <button  @click="clear" style="margin-top:20px;padding:25px;background-color:#e0ffff">清空内容</button>
        <button  @click="editHtml" style="margin-top:20px;padding:25px;background-color:#e0ffff">编辑html</button>
        <button  @click="unDo" style="margin-top:20px;padding:25px;background-color:#e0ffff">撤销上步操作</button>
        <button  @click="reDo" style="margin-top:20px;padding:25px;background-color:#e0ffff">恢复上步操作</button>
        <button  @click="showInsertDialog" style="margin-top:20px;padding:25px;background-color:#e0ffff">插入链接</button>
        <button  @click="showTableDialog" style="margin-top:20px;padding:25px;background-color:#e0ffff">插入表格</button>
        <button  @click="chooseTextColor" style="margin-top:20px;padding:25px;background-color:#e0ffff">选择字体颜色</button>
        <button  @click="choosebackgroundColor" style="margin-top:20px;padding:25px;background-color:#e0ffff">选择字体背景颜色</button>
      </div>
    </scroller>
    </div>
</template>




export default {
    data () {
        return {
            statusBarStyle: 'LightContent'
        }
    },
    methods: {
        setBold(){
            this.$refs['richtext'].setBold();
        },
        setUnderline(){
            this.$refs['richtext'].setUnderline();
        },
        setDash(){
            this.$refs['richtext'].setDash();
        },
        removeFormat(){
            this.$refs['richtext'].removeFormat();
        },
        setNormal(){
            this.$refs['richtext'].setTextSize('normal');
        },
        setH1(){
            this.$refs['richtext'].setTextSize('h1');
        },
        setH2(){
            this.$refs['richtext'].setTextSize('h2');
        },
        setH3(){
            this.$refs['richtext'].setTextSize('h3');
        },
        setH4(){
            this.$refs['richtext'].setTextSize('h4');
        },
        setH5(){
            this.$refs['richtext'].setTextSize('h5');
        },
        setH6(){
            this.$refs['richtext'].setTextSize('h6');
        },
        setSuperScript(){
            this.$refs['richtext'].setSuperScript();
        },
        setSubScript(){
            this.$refs['richtext'].setSubScript();
        },
        setOrderWithPoint(){
            this.$refs['richtext'].setOrderWithPoint();
        },
        setOrderWithNumber(){
            this.$refs['richtext'].setOrderWithNumber();
        },
        setQuoteBlock(){
            this.$refs['richtext'].setQuoteBlock();
        },
        setCodeBlock(){
            this.$refs['richtext'].setCodeBlock();
        },
        setAlignLeft(){
            this.$refs['richtext'].setTextAlign('left');
        },
        setAlignRight(){
            this.$refs['richtext'].setTextAlign('right');
        },
        setAlignCenter(){
            this.$refs['richtext'].setTextAlign('center');
        },
        setAlignJustify(){
            this.$refs['richtext'].setTextAlign('justify');
        },
        setUnIndent(){
            this.$refs['richtext'].setUnIndent();
        },
        setHorizontalDividingLine(){
            this.$refs['richtext'].setHorizontalDividingLine();
        },
        setIndent(){
           this.$refs['richtext'].setIndent();
        },
        clear(){
           this.$refs['richtext'].clear();
        },
        editHtml(){
           this.$refs['richtext'].editHtml();
        },
        unDo(){
           this.$refs['richtext'].unDo();
        },
        reDo(){
           this.$refs['richtext'].reDo();
        },
        showTableDialog(){
           this.$refs['richtext'].showInsertTableDialog();
        },
        showInsertDialog(){
            this.$refs['richtext'].showInsertLinkDialog();
        },
        chooseTextColor(){
            this.$refs['richtext'].showColorPickerDialog('textForeground')
        },
        choosebackgroundColor(){
            this.$refs['richtext'].showColorPickerDialog('textBackground')
        },
        onLinkInsert(params){
            this.$notice.toast({
                message: 'title' + params.title + '\r\nurl：' + params.url
            });
            this.$refs['richtext'].setLink(params.title,params.url);
        },
        onTableInsert(params){
            this.$notice.toast({
                message: 'colCount' + params.colCount + '\r\nrowCount：' + params.rowCount
            });
            this.$refs['richtext'].insertTable(params.colCount,params.rowCount);
        },
        onColorSelected(params){
            this.$notice.toast({
                message: 'type' + params.type + '\r\ncolor：' + params.color
            });
            if(params.type=='textForeground'){
                this.$refs['richtext'].setTextColor(params.color);
            }else{
                this.$refs['richtext'].setTextBackgroundColor(params.color);
            }
        }
}
</script>

