package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy extends com.yuzhix.idiom.module.mine.model.ReadLaterEntity
    implements RealmObjectProxy, com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface {

    static final class ReadLaterEntityColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long userIdIndex;
        long titleIndex;
        long linkIndex;
        long timeIndex;

        ReadLaterEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ReadLaterEntity");
            this.userIdIndex = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.linkIndex = addColumnDetails("link", "link", objectSchemaInfo);
            this.timeIndex = addColumnDetails("time", "time", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ReadLaterEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ReadLaterEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ReadLaterEntityColumnInfo src = (ReadLaterEntityColumnInfo) rawSrc;
            final ReadLaterEntityColumnInfo dst = (ReadLaterEntityColumnInfo) rawDst;
            dst.userIdIndex = src.userIdIndex;
            dst.titleIndex = src.titleIndex;
            dst.linkIndex = src.linkIndex;
            dst.timeIndex = src.timeIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ReadLaterEntityColumnInfo columnInfo;
    private ProxyState<com.yuzhix.idiom.module.mine.model.ReadLaterEntity> proxyState;

    com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ReadLaterEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.yuzhix.idiom.module.mine.model.ReadLaterEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.userIdIndex);
    }

    @Override
    public void realmSet$userId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.userIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.userIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$link() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.linkIndex);
    }

    @Override
    public void realmSet$link(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.linkIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.linkIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.linkIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.linkIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$time() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timeIndex);
    }

    @Override
    public void realmSet$time(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timeIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ReadLaterEntity", 4, 0);
        builder.addPersistedProperty("userId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("link", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("time", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ReadLaterEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ReadLaterEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ReadLaterEntity";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ReadLaterEntity";
    }

    @SuppressWarnings("cast")
    public static com.yuzhix.idiom.module.mine.model.ReadLaterEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.yuzhix.idiom.module.mine.model.ReadLaterEntity obj = realm.createObjectInternal(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class, true, excludeFields);

        final com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface objProxy = (com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) obj;
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'userId' to null.");
            } else {
                objProxy.realmSet$userId((int) json.getInt("userId"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("link")) {
            if (json.isNull("link")) {
                objProxy.realmSet$link(null);
            } else {
                objProxy.realmSet$link((String) json.getString("link"));
            }
        }
        if (json.has("time")) {
            if (json.isNull("time")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
            } else {
                objProxy.realmSet$time((long) json.getLong("time"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.yuzhix.idiom.module.mine.model.ReadLaterEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.yuzhix.idiom.module.mine.model.ReadLaterEntity obj = new com.yuzhix.idiom.module.mine.model.ReadLaterEntity();
        final com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface objProxy = (com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'userId' to null.");
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("link")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$link((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$link(null);
                }
            } else if (name.equals("time")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$time((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class), false, Collections.<String>emptyList());
        io.realm.com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy obj = new io.realm.com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.yuzhix.idiom.module.mine.model.ReadLaterEntity copyOrUpdate(Realm realm, ReadLaterEntityColumnInfo columnInfo, com.yuzhix.idiom.module.mine.model.ReadLaterEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.yuzhix.idiom.module.mine.model.ReadLaterEntity) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.yuzhix.idiom.module.mine.model.ReadLaterEntity copy(Realm realm, ReadLaterEntityColumnInfo columnInfo, com.yuzhix.idiom.module.mine.model.ReadLaterEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.yuzhix.idiom.module.mine.model.ReadLaterEntity) cachedRealmObject;
        }

        com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface realmObjectSource = (com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) newObject;

        Table table = realm.getTable(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.userIdIndex, realmObjectSource.realmGet$userId());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.linkIndex, realmObjectSource.realmGet$link());
        builder.addInteger(columnInfo.timeIndex, realmObjectSource.realmGet$time());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.yuzhix.idiom.module.mine.model.ReadLaterEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        long tableNativePtr = table.getNativePtr();
        ReadLaterEntityColumnInfo columnInfo = (ReadLaterEntityColumnInfo) realm.getSchema().getColumnInfo(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$userId(), false);
        String realmGet$title = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$link = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$time(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        long tableNativePtr = table.getNativePtr();
        ReadLaterEntityColumnInfo columnInfo = (ReadLaterEntityColumnInfo) realm.getSchema().getColumnInfo(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        com.yuzhix.idiom.module.mine.model.ReadLaterEntity object = null;
        while (objects.hasNext()) {
            object = (com.yuzhix.idiom.module.mine.model.ReadLaterEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$userId(), false);
            String realmGet$title = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$link = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$time(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.yuzhix.idiom.module.mine.model.ReadLaterEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        long tableNativePtr = table.getNativePtr();
        ReadLaterEntityColumnInfo columnInfo = (ReadLaterEntityColumnInfo) realm.getSchema().getColumnInfo(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$userId(), false);
        String realmGet$title = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$link = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$time(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        long tableNativePtr = table.getNativePtr();
        ReadLaterEntityColumnInfo columnInfo = (ReadLaterEntityColumnInfo) realm.getSchema().getColumnInfo(com.yuzhix.idiom.module.mine.model.ReadLaterEntity.class);
        com.yuzhix.idiom.module.mine.model.ReadLaterEntity object = null;
        while (objects.hasNext()) {
            object = (com.yuzhix.idiom.module.mine.model.ReadLaterEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$userId(), false);
            String realmGet$title = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$link = ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) object).realmGet$time(), false);
        }
    }

    public static com.yuzhix.idiom.module.mine.model.ReadLaterEntity createDetachedCopy(com.yuzhix.idiom.module.mine.model.ReadLaterEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.yuzhix.idiom.module.mine.model.ReadLaterEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.yuzhix.idiom.module.mine.model.ReadLaterEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.yuzhix.idiom.module.mine.model.ReadLaterEntity) cachedObject.object;
            }
            unmanagedObject = (com.yuzhix.idiom.module.mine.model.ReadLaterEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface unmanagedCopy = (com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) unmanagedObject;
        com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface realmSource = (com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$link(realmSource.realmGet$link());
        unmanagedCopy.realmSet$time(realmSource.realmGet$time());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ReadLaterEntity = proxy[");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{link:");
        stringBuilder.append(realmGet$link() != null ? realmGet$link() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{time:");
        stringBuilder.append(realmGet$time());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy aReadLaterEntity = (com_yuzhix_idiom_module_mine_model_ReadLaterEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aReadLaterEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aReadLaterEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aReadLaterEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
