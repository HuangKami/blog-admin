
function zeroFirst(num){
    if (num < 10){
        return "0" + num;
    }
    else{
 return "" + num;        
}
}

Date.prototype.toLocaleString = function() {
    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate() 
    	+ " " + zeroFirst(this.getHours()) + ":" + zeroFirst(this.getMinutes());
};