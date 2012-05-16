
function Map() {
	this.elements = new Array();
	this.size = function () {
		return this.elements.length;
	};
	this.put = function (_key, _value) {
		this.elements.push({key:_key, value:_value});
	};
	this.remove = function (_key) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		}
		catch (e) {
			bln = false;
		}
		return bln;
	};
	this.containsKey = function (_key) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					bln = true;
				}
			}
		}
		catch (e) {
			bln = false;
		}
		return bln;
	};
	this.indexOfKey = function (_key) {
		var bln = "";
		try {
			for (i = 0; i < this.elements.length; i++) {
				var el=this.elements[i].key;
				//alert(el);
				if (el.indexOf(_key)!=-1) {
					if(bln!=""){
					bln = bln+",";
					}
					bln = bln+el;
				}
			}
		}
		catch (e) {
			bln = "";
		}
		return bln;
	};
	this.ArrayIterative = function (_count) {
		 
		return this.elements[_count].key;
	};
	this.get = function (_key) {
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return this.elements[i];
				}
			}
		}
		catch (e) {
			return null;
		}
	};
}

