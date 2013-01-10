define([ "require", "ember", "ember_data" ], function(require, Ember) {
	var Volumeinfo = DS.Model.extend({
		primaryKey: 'id',
		id : DS.attr('number'),
		authors: [],
		description: DS.attr('string'),
		image_links: DS.belongsTo('BooksApp.ImageLink', { embedded: true }),
		industry_identifiers: DS.hasMany('BooksApp.IndustryIdentifier', { embedded: true }),
		title: DS.attr('string'),
		subtitle: DS.attr('string'),
		publishedDate: DS.attr('date'),
		categoriess: DS.hasMany('BooksApp.Category', { embedded: true })

	});
	return Volumeinfo;
});