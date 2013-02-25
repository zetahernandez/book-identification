define(["require", "ember", "ember_data"], function (require, Ember) {
	var IamgeLink = DS.Model.extend({
		primaryKey: 'id',
		thumbnail: DS.attr('string'),
		smallThumbnail: DS.attr('string'),
		small: DS.attr('string'),
		medium: DS.attr('string'),
		large: DS.attr('string'),
		extraLarge: DS.attr('string'),

		maxSizeImage: function () {
			if(this.get('large') !== null) return this.get('large');
			if(this.get('medium') !== null) return this.get('medium');
			if(this.get('small') !== null) return this.get('small');
			if(this.get('smallThumbnail') !== null) return this.get('smallThumbnail');
			if(this.get('thumbnail') !== null) return this.get('thumbnail');
		}.property()
	});
	return IamgeLink;
});