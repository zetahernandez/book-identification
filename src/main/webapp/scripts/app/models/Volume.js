define([ "require", "ember", "ember_data"], function(require, Ember) {
	var Volume = DS.Model.extend({
		primaryKey: 'id',
		id : DS.attr('number'),
		bookId : DS.attr('string'),
		kind : DS.attr('string'),
		volumeInfo : DS.belongsTo('BooksApp.VolumeInfo', { embedded: true })
	});	
	return Volume;
});