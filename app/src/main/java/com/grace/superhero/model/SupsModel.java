package com.grace.superhero.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "slug",
        "powerstats",
        "appearance",
        "biography",
        "work",
        "connections",
        "images"
})

public class SupsModel implements Serializable, Parcelable {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("slug")
        private String slug;
        @JsonProperty("powerstats")
        private PowerStats powerstats;
        @JsonProperty("appearance")
        private Appearance appearance;
        @JsonProperty("biography")
        private Biography biography;
        @JsonProperty("work")
        private Work work;
        @JsonProperty("connections")
        private Connections connections;
        @JsonProperty("images")
        private Images images;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    protected SupsModel(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        slug = in.readString();
    }

    public static final Creator<SupsModel> CREATOR = new Creator<SupsModel>() {
        @Override
        public SupsModel createFromParcel(Parcel in) {
            return new SupsModel(in);
        }

        @Override
        public SupsModel[] newArray(int size) {
            return new SupsModel[size];
        }
    };

    @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("slug")
        public String getSlug() {
            return slug;
        }

        @JsonProperty("slug")
        public void setSlug(String slug) {
            this.slug = slug;
        }

        @JsonProperty("powerstats")
        public PowerStats getPowerstats() {
            return powerstats;
        }

        @JsonProperty("powerstats")
        public void setPowerstats(PowerStats powerstats) {
            this.powerstats = powerstats;
        }

        @JsonProperty("appearance")
        public Appearance getAppearance() {
            return appearance;
        }

        @JsonProperty("appearance")
        public void setAppearance(Appearance appearance) {
            this.appearance = appearance;
        }

        @JsonProperty("biography")
        public Biography getBiography() {
            return biography;
        }

        @JsonProperty("biography")
        public void setBiography(Biography biography) {
            this.biography = biography;
        }

        @JsonProperty("work")
        public Work getWork() {
            return work;
        }

        @JsonProperty("work")
        public void setWork(Work work) {
            this.work = work;
        }

        @JsonProperty("connections")
        public Connections getConnections() {
            return connections;
        }

        @JsonProperty("connections")
        public void setConnections(Connections connections) {
            this.connections = connections;
        }

        @JsonProperty("images")
        public Images getImages() {
            return images;
        }

        @JsonProperty("images")
        public void setImages(Images images) {
            this.images = images;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeString(slug);
            dest.writeParcelable(appearance, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeParcelable(biography, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeParcelable(connections, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeParcelable(images, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeParcelable(powerstats, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
            dest.writeParcelable(work, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "gender",
            "race",
            "height",
            "weight",
            "eyeColor",
            "hairColor"
    })
    public static class Appearance implements Serializable, Parcelable {

        @JsonProperty("gender")
        private String gender;
        @JsonProperty("race")
        private String race;
        @JsonProperty("height")
        private List<String> height = null;
        @JsonProperty("weight")
        private List<String> weight = null;
        @JsonProperty("eyeColor")
        private String eyeColor;
        @JsonProperty("hairColor")
        private String hairColor;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        protected Appearance(Parcel in) {
            gender = in.readString();
            race = in.readString();
            height = in.createStringArrayList();
            weight = in.createStringArrayList();
            eyeColor = in.readString();
            hairColor = in.readString();
        }

        public static final Creator<Appearance> CREATOR = new Creator<Appearance>() {
            @Override
            public Appearance createFromParcel(Parcel in) {
                return new Appearance(in);
            }

            @Override
            public Appearance[] newArray(int size) {
                return new Appearance[size];
            }
        };

        @JsonProperty("gender")
        public String getGender() {
            return gender;
        }

        @JsonProperty("gender")
        public void setGender(String gender) {
            this.gender = gender;
        }

        @JsonProperty("race")
        public String getRace() {
            return race;
        }

        @JsonProperty("race")
        public void setRace(String race) {
            this.race = race;
        }

        @JsonProperty("height")
        public List<String> getHeight() {
            return height;
        }

        @JsonProperty("height")
        public void setHeight(List<String> height) {
            this.height = height;
        }

        @JsonProperty("weight")
        public List<String> getWeight() {
            return weight;
        }

        @JsonProperty("weight")
        public void setWeight(List<String> weight) {
            this.weight = weight;
        }

        @JsonProperty("eyeColor")
        public String getEyeColor() {
            return eyeColor;
        }

        @JsonProperty("eyeColor")
        public void setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
        }

        @JsonProperty("hairColor")
        public String getHairColor() {
            return hairColor;
        }

        @JsonProperty("hairColor")
        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(gender);
            dest.writeString(race);
            dest.writeStringList(height);
            dest.writeStringList(weight);
            dest.writeString(eyeColor);
            dest.writeString(hairColor);
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "fullName",
            "alterEgos",
            "aliases",
            "placeOfBirth",
            "firstAppearance",
            "publisher",
            "alignment"
    })
    public static class Biography implements Serializable, Parcelable {

        @JsonProperty("fullName")
        private String fullName;
        @JsonProperty("alterEgos")
        private String alterEgos;
        @JsonProperty("aliases")
        private List<String> aliases = null;
        @JsonProperty("placeOfBirth")
        private String placeOfBirth;
        @JsonProperty("firstAppearance")
        private String firstAppearance;
        @JsonProperty("publisher")
        private String publisher;
        @JsonProperty("alignment")
        private String alignment;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        protected Biography(Parcel in) {
            fullName = in.readString();
            alterEgos = in.readString();
            aliases = in.createStringArrayList();
            placeOfBirth = in.readString();
            firstAppearance = in.readString();
            publisher = in.readString();
            alignment = in.readString();
        }

        public static final Creator<Biography> CREATOR = new Creator<Biography>() {
            @Override
            public Biography createFromParcel(Parcel in) {
                return new Biography(in);
            }

            @Override
            public Biography[] newArray(int size) {
                return new Biography[size];
            }
        };

        @JsonProperty("fullName")
        public String getFullName() {
            return fullName;
        }

        @JsonProperty("fullName")
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        @JsonProperty("alterEgos")
        public String getAlterEgos() {
            return alterEgos;
        }

        @JsonProperty("alterEgos")
        public void setAlterEgos(String alterEgos) {
            this.alterEgos = alterEgos;
        }

        @JsonProperty("aliases")
        public List<String> getAliases() {
            return aliases;
        }

        @JsonProperty("aliases")
        public void setAliases(List<String> aliases) {
            this.aliases = aliases;
        }

        @JsonProperty("placeOfBirth")
        public String getPlaceOfBirth() {
            return placeOfBirth;
        }

        @JsonProperty("placeOfBirth")
        public void setPlaceOfBirth(String placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
        }

        @JsonProperty("firstAppearance")
        public String getFirstAppearance() {
            return firstAppearance;
        }

        @JsonProperty("firstAppearance")
        public void setFirstAppearance(String firstAppearance) {
            this.firstAppearance = firstAppearance;
        }

        @JsonProperty("publisher")
        public String getPublisher() {
            return publisher;
        }

        @JsonProperty("publisher")
        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        @JsonProperty("alignment")
        public String getAlignment() {
            return alignment;
        }

        @JsonProperty("alignment")
        public void setAlignment(String alignment) {
            this.alignment = alignment;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(fullName);
            dest.writeString(alterEgos);
            dest.writeStringList(aliases);
            dest.writeString(placeOfBirth);
            dest.writeString(firstAppearance);
            dest.writeString(publisher);
            dest.writeString(alignment);
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "groupAffiliation",
            "relatives"
    })
    public static class Connections implements Serializable, Parcelable {

        @JsonProperty("groupAffiliation")
        private String groupAffiliation;
        @JsonProperty("relatives")
        private String relatives;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        protected Connections(Parcel in) {
            groupAffiliation = in.readString();
            relatives = in.readString();
        }

        public static final Creator<Connections> CREATOR = new Creator<Connections>() {
            @Override
            public Connections createFromParcel(Parcel in) {
                return new Connections(in);
            }

            @Override
            public Connections[] newArray(int size) {
                return new Connections[size];
            }
        };

        @JsonProperty("groupAffiliation")
        public String getGroupAffiliation() {
            return groupAffiliation;
        }

        @JsonProperty("groupAffiliation")
        public void setGroupAffiliation(String groupAffiliation) {
            this.groupAffiliation = groupAffiliation;
        }

        @JsonProperty("relatives")
        public String getRelatives() {
            return relatives;
        }

        @JsonProperty("relatives")
        public void setRelatives(String relatives) {
            this.relatives = relatives;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(groupAffiliation);
            dest.writeString(relatives);
        }
    }

    public static class Images implements Serializable, Parcelable {

        @JsonProperty("xs")
        private String xs;
        @JsonProperty("sm")
        private String sm;
        @JsonProperty("md")
        private String md;
        @JsonProperty("lg")
        private String lg;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        protected Images(Parcel in) {
            xs = in.readString();
            sm = in.readString();
            md = in.readString();
            lg = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(xs);
            dest.writeString(sm);
            dest.writeString(md);
            dest.writeString(lg);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Images> CREATOR = new Creator<Images>() {
            @Override
            public Images createFromParcel(Parcel in) {
                return new Images(in);
            }

            @Override
            public Images[] newArray(int size) {
                return new Images[size];
            }
        };

        @JsonProperty("xs")
        public String getXs() {
            return xs;
        }

        @JsonProperty("xs")
        public void setXs(String xs) {
            this.xs = xs;
        }

        @JsonProperty("sm")
        public String getSm() {
            return sm;
        }

        @JsonProperty("sm")
        public void setSm(String sm) {
            this.sm = sm;
        }

        @JsonProperty("md")
        public String getMd() {
            return md;
        }

        @JsonProperty("md")
        public void setMd(String md) {
            this.md = md;
        }

        @JsonProperty("lg")
        public String getLg() {
            return lg;
        }

        @JsonProperty("lg")
        public void setLg(String lg) {
            this.lg = lg;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "intelligence",
            "strength",
            "speed",
            "durability",
            "power",
            "combat"
    })
    public static class PowerStats implements Serializable, Parcelable {

        @JsonProperty("intelligence")
        private Integer intelligence;
        @JsonProperty("strength")
        private Integer strength;
        @JsonProperty("speed")
        private Integer speed;
        @JsonProperty("durability")
        private Integer durability;
        @JsonProperty("power")
        private Integer power;
        @JsonProperty("combat")
        private Integer combat;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        protected PowerStats(Parcel in) {
            if (in.readByte() == 0) {
                intelligence = null;
            } else {
                intelligence = in.readInt();
            }
            if (in.readByte() == 0) {
                strength = null;
            } else {
                strength = in.readInt();
            }
            if (in.readByte() == 0) {
                speed = null;
            } else {
                speed = in.readInt();
            }
            if (in.readByte() == 0) {
                durability = null;
            } else {
                durability = in.readInt();
            }
            if (in.readByte() == 0) {
                power = null;
            } else {
                power = in.readInt();
            }
            if (in.readByte() == 0) {
                combat = null;
            } else {
                combat = in.readInt();
            }
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (intelligence == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(intelligence);
            }
            if (strength == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(strength);
            }
            if (speed == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(speed);
            }
            if (durability == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(durability);
            }
            if (power == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(power);
            }
            if (combat == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(combat);
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<PowerStats> CREATOR = new Creator<PowerStats>() {
            @Override
            public PowerStats createFromParcel(Parcel in) {
                return new PowerStats(in);
            }

            @Override
            public PowerStats[] newArray(int size) {
                return new PowerStats[size];
            }
        };

        @JsonProperty("intelligence")
        public Integer getIntelligence() {
            return intelligence;
        }

        @JsonProperty("intelligence")
        public void setIntelligence(Integer intelligence) {
            this.intelligence = intelligence;
        }

        @JsonProperty("strength")
        public Integer getStrength() {
            return strength;
        }

        @JsonProperty("strength")
        public void setStrength(Integer strength) {
            this.strength = strength;
        }

        @JsonProperty("speed")
        public Integer getSpeed() {
            return speed;
        }

        @JsonProperty("speed")
        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @JsonProperty("durability")
        public Integer getDurability() {
            return durability;
        }

        @JsonProperty("durability")
        public void setDurability(Integer durability) {
            this.durability = durability;
        }

        @JsonProperty("power")
        public Integer getPower() {
            return power;
        }

        @JsonProperty("power")
        public void setPower(Integer power) {
            this.power = power;
        }

        @JsonProperty("combat")
        public Integer getCombat() {
            return combat;
        }

        @JsonProperty("combat")
        public void setCombat(Integer combat) {
            this.combat = combat;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "occupation",
            "base"
    })
    public static class Work implements Serializable, Parcelable {

        @JsonProperty("occupation")
        private String occupation;
        @JsonProperty("base")
        private String base;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        protected Work(Parcel in) {
            occupation = in.readString();
            base = in.readString();
        }

        public static final Creator<Work> CREATOR = new Creator<Work>() {
            @Override
            public Work createFromParcel(Parcel in) {
                return new Work(in);
            }

            @Override
            public Work[] newArray(int size) {
                return new Work[size];
            }
        };

        @JsonProperty("occupation")
        public String getOccupation() {
            return occupation;
        }

        @JsonProperty("occupation")
        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        @JsonProperty("base")
        public String getBase() {
            return base;
        }

        @JsonProperty("base")
        public void setBase(String base) {
            this.base = base;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(occupation);
            dest.writeString(base);
        }
    }

}
