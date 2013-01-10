define([ "require", "ember", "ember_data"], function(require, Ember) {
	var Volume = DS.Model.extend({
		primaryKey: 'id',
		id : DS.attr('number'),
		book_id : DS.attr('string'),
		kind : DS.attr('string'),
		volume_info : DS.belongsTo('BooksApp.VolumeInfo', { embedded: true })
	});	
	return Volume;
});