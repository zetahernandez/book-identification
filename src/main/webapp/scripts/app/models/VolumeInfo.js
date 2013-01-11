define([ "require", "ember", "ember_data" ], function(require, Ember) {
	var Volumeinfo = DS.Model.extend({
		primaryKey: 'id',
		id : DS.attr('number'),
		authors: [],
		description: DS.attr('string'),
		imageLinks: DS.belongsTo('BooksApp.ImageLink', { embedded: true }),
		industryIdentifiers: DS.hasMany('BooksApp.IndustryIdentifier', { embedded: true }),
		title: DS.attr('string'),
		subtitle: DS.attr('string'),
		publishedDate: DS.attr('date'),
		categoriess: DS.hasMany('BooksApp.Category', { embedded: true }),
		
		unescapedDescription: function() {
			return this.get('description').htmlSafe();
		}.property('html'),

	});
	return Volumeinfo;
});