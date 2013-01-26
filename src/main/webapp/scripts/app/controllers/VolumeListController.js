define([ "require", "ember"], function(r,Ember) {
    var VolumeListController = Ember.ArrayController.extend({
        page:1,
        init: function (){
            this.set('content',	BooksApp.Volume.find({
                "page":1
            }));
            var volController = this;
            $(window).endlessScroll({
                loader: '<div class="loading"><div>',
                content: function (fireSequence,pageSequence,scrollDirection){
                    return " "; 
                },
                callback: function(p){
                    volController.addMoreVolumes( volController.get("page") + 1 );
                }
            });
        },
        filterByCategory : function(category) {
            this.set('content',	BooksApp.Volume.find({
                categoryId: category.get('id')
                }));
        },
        showAll : function() {
            this.set('content',BooksApp.Volume.find());
        },
        
        contentChanged: function() {
            var mutableVolumes = [];

            this.get('content').forEach(function(vol) {
                mutableVolumes.pushObject(vol);
            });

            this.set('currentVolumes', mutableVolumes);
        }.observes('content', 'content.isLoaded'),

        addMoreVolumes : function ( page ){
            
           var mutableVolumes = [];

            this.get('content').forEach(function(vol) {
                mutableVolumes.pushObject(vol);
            });
            
            this.page = page;
            var books = BooksApp.Volume.find({
                "page":page
            });

            books.forEach(function(vol) {
                mutableVolumes.pushObject(vol);
            });
            
            this.get('currentVolumes').pushObjects( mutableVolumes );
        
        }
    });
    return VolumeListController;
});