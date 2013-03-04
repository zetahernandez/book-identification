define(
["ember"], function (Ember) {
	var FileToUpload = Ember.Object.extend({
		file: null,
		name:function(){
			return this.get('file.name');
		}.property('file.name'),
		identified: false,
		size: function() {
			return this.get('file.size');
		}.property('file.size')
	});

	return FileToUpload;
});