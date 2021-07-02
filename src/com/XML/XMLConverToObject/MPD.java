package com.XML.XMLConverToObject;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1217:10
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="MPD")
public class MPD {

    public MPD() {
    }
    @XmlElement(name = "Period")
    private Period period;

    @XmlTransient
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    static class Period{

        @XmlElement(name = "AdaptationSet")
        List<Adaptation> adaptations;

        public Period() {
        }

        public void setAdaptations(List<Adaptation> adaptations) {
            this.adaptations = adaptations;
        }

        @XmlTransient
        public List<Adaptation> getAdaptations() {
            return adaptations;
        }

        @Override
        public String toString() {
            return "Period{" +
                    "adaptations=" + adaptations +
                    '}';
        }

        static class Adaptation{

            @XmlAttribute
            private String contentType; //vidoe and audio 区分的类型
            @XmlElement(name = "SegmentTemplate")
            private SegmentTemplate SegmentTemplate;
            @XmlElement (name = "Representation")
            private List<Representation> representation;

            public Adaptation() {
            }

            @XmlTransient
            public String getContentType() {
                return contentType;
            }
            @XmlTransient
            public Adaptation.SegmentTemplate getSegmentTemplate() {
                return SegmentTemplate;
            }
            @XmlTransient
            public List<Representation> getRepresentation() {
                return representation;
            }




            @Override
            public String toString() {
                return "Adaptation{" +
                        "contentType='" + contentType + '\'' +
                        ", SegmentTemplate=" + SegmentTemplate +
                        ", representation=" + representation +
                        '}';
            }

            static class SegmentTemplate{
                @XmlAttribute
                private String media;               //模板型式
                @XmlAttribute
                private String initialization;      //初始化文件模板
                @XmlAttribute
                private Integer startNumber;        //开始字母

                public SegmentTemplate() {
                }

                @XmlTransient
                public String getMedia() {
                    return media;
                }
                @XmlTransient
                public String getInitialization() {
                    return initialization;
                }
                @XmlTransient
                public Integer getStartNumber() {
                    return startNumber;
                }

                @Override
                public String toString() {
                    return "SegmentTemplate{" +
                            "media='" + media + '\'' +
                            ", initialization='" + initialization + '\'' +
                            ", startNumber=" + startNumber +
                            '}';
                }
            }

            static class Representation{
                @XmlAttribute
                private String id;                  //模板开头str
                @XmlAttribute
                private String mimeType;            //类型

                public Representation() {
                }

                @XmlTransient
                public String getId() {
                    return id;
                }
                @XmlTransient
                public String getMimeType() {
                    return mimeType;
                }

                @Override
                public String toString() {
                    return "Representation{" +
                            "id='" + id + '\'' +
                            ", mimeType='" + mimeType + '\'' +
                            '}';
                }
            }
        }

    }


    @Override
    public String toString() {
        return "MPD{" +
                "period=" + period +
                '}';
    }
}
