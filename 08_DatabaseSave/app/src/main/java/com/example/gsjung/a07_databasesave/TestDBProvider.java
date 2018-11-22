package com.example.gsjung.a07_databasesave;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;

public class TestDBProvider extends ContentProvider {
    static final Uri CONTENT_URI = Uri.parse("content://a07_databasesave.test/people");
    static final int GETALL = 1;
    static final int GETONE = 2;

    static final UriMatcher matcher;
    static {
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI("a07_databasesave.test","people",GETALL);
        matcher.addURI("a07_databasesave.test","people/*",GETONE);
    }

    SQLiteDatabase mDB;
    class TestDBHelper extends SQLiteOpenHelper{

        public TestDBHelper(Context context) {
            super(context, "test.db", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS people "
                    + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER);");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
            db.execSQL("DROP TABLE IF EXISTS people;");
            onCreate(db);
        }
    }


    public TestDBProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int cnt = 0;
        switch (matcher.match(uri)) {
            case GETALL:
                cnt = mDB.delete("people", selection, selectionArgs);
                break;
            case GETONE:
                String where = "name = '" + uri.getPathSegments().get(1) + "'";
                if(TextUtils.isEmpty(selection) == false) {
                    where += " AND " + selection;
                }
                cnt = mDB.delete("people", where, selectionArgs);
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }

    @Override
    public String getType(Uri uri) {
        switch (matcher.match(uri)) {
            case GETALL:
                return "vnd.android.cursor.dir/vnd.vr.people";
            case GETONE:
                return "vnd.android.cursor.item/vnd.vr.people";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long row = mDB.insert("people", null, values);
        if(row > 0) {
            Uri notiuri = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(notiuri, null);
            return notiuri;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        TestDBHelper helper = new TestDBHelper(getContext());
        mDB = helper.getWritableDatabase();
        return (mDB != null);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String sql = "SELECT * FROM people";
        if(matcher.match(uri) == GETONE) {
            sql += " WHERE name='";
            sql += uri.getPathSegments().get(1);
            sql += "'";
        }
        sql += ";";
        Cursor cursor = mDB.rawQuery(sql, null);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int cnt = 0;
        switch (matcher.match(uri)) {
            case GETALL:
                cnt = mDB.update("people", values, selection, selectionArgs);
                break;
            case GETONE:
                String where = "name = '" + uri.getPathSegments().get(1) + "'";
                if (TextUtils.isEmpty(selection) == false) {
                    where += " AND " + selection;
                }
                cnt = mDB.update("people", values, where, selectionArgs);
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }
}
