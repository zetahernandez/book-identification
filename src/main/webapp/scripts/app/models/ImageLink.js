define([ "require", "ember", "ember_data"], function(require, Ember) {
	var IamgeLink = DS.Model.extend({
		primaryKey: 'id',
		id : DS.attr('number'),
		thumbnail : DS.attr('string'),
		smallThumbnail : DS.attr('string'),
		small : DS.attr('string'),
		medium : DS.attr('string'),
		large : DS.attr('string'),
		extraLarge : DS.attr('string'),
		
		maxSizeImage : function() {
			if(this.get('large') !== undefined)
				return this.get('large');
			if(this.get('medium') !== undefined)
				return this.get('medium');
			if(this.get('small') !== undefined)
				return this.get('small');
			if(this.get('smallThumbnail') != undefined)
				return this.get('smallThumbnail');
			if(this.get('thumbnail') !== undefined)
				return this.get('thumbnail');
		}.property()
	});
	return IamgeLink;
});